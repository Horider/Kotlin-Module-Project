class StartApp {
    private var levelMenu = MenuLevel.ArchiveMenu
    private val mapArchive = MapArchive(mutableMapOf())
    private val menu = MenuSelect()
    private var keyReturned: Any? = ""

    fun startApp() {
        do {
            if (levelMenu == MenuLevel.ArchiveMenu) {
                processArchiveMenu()
            } else if (levelMenu == MenuLevel.NoteMenu) {
                processNoteMenu()
            }
        } while (keyReturned != "exitApp")
        println("Вы вышли из программы")
    }

    private fun processArchiveMenu() {
        keyReturned = menu.makeMenu(levelMenu, mapArchive)
        if (mapArchive.mapArchive.contains(keyReturned)) {
            levelMenu = MenuLevel.NoteMenu
            println("Выбран архив $keyReturned")
        }
    }

    private fun processNoteMenu() {
        val keyForMap = keyReturned.toString()
        when (val keyReturned = menu.makeMenu(levelMenu, mapArchive, keyForMap)) {
            "exitMenu" -> levelMenu = MenuLevel.ArchiveMenu
            "noteCreated" -> {}
            else -> processNoteActions(keyForMap, keyReturned)
        }
    }

    private fun processNoteActions(keyForMap: String, keyReturned: Any?) {
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
