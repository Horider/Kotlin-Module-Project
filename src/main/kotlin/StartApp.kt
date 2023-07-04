class StartApp {
    private var levelMenu = MenuLevel.ArchiveMenu
    private val mapArchive = MapArchive(mutableMapOf())
    private val menu = MenuSelect()
    private var keyReturned: MenuKey? = null

    fun startApp() {
        do {
            if (levelMenu == MenuLevel.ArchiveMenu) {
                processArchiveMenu()
            } else if (levelMenu == MenuLevel.NoteMenu) {
                processNoteMenu()
            }
        } while (keyReturned != MenuKey.ExitApp)
        println("Вы вышли из программы")
    }

    private fun processArchiveMenu() {
        keyReturned = menu.makeMenu(levelMenu, mapArchive)
        if (keyReturned is MenuKey.ArchiveKey && mapArchive.mapArchive.contains((keyReturned as MenuKey.ArchiveKey).key)) {
            levelMenu = MenuLevel.NoteMenu
            println("Выбран архив ${(keyReturned as MenuKey.ArchiveKey).key}")
        }
    }

    private fun processNoteMenu() {
        val keyForMap = (keyReturned as MenuKey.ArchiveKey).key
        when (val keyReturned = menu.makeMenu(levelMenu, mapArchive, keyForMap)) {
            is MenuKey.ExitMenu -> levelMenu = MenuLevel.ArchiveMenu
            is MenuKey.NoteCreated -> {}
            else -> processNoteActions(keyForMap, (keyReturned as MenuKey.NoteKey).key)
        }
    }

    private fun processNoteActions(keyForMap: String, keyReturned: String) {
        print("Содержание заметки $keyReturned : ")
        println(mapArchive.mapArchive[keyForMap]?.mutableMapNotes?.get(keyReturned)?.toString())
        println("1. Удалить заметку")
        println("2. Вернуться")
        val actionNote = menu.readMenu(2)
        if (actionNote == 1) {
            mapArchive.mapArchive[keyForMap]?.mutableMapNotes?.remove(keyReturned)
        }
    }
}

