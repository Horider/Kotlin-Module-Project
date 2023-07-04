class MenuSelect {

    fun makeMenu(level: MenuLevel, mapArchive: MapArchive, keyForMap: String = ""): MenuKey? {
        println("Меню ${level.levelName}")
        println("Введите число, соответствующее пункту меню: ")

        return when (level) {
            MenuLevel.ArchiveMenu -> processMenu(level, mapArchive)
            MenuLevel.NoteMenu -> processMenu(level, mapArchive, keyForMap)
            else -> null
        }
    }

    private fun processMenu(level: MenuLevel, mapArchive: MapArchive, keyForMap: String = ""): MenuKey {
        val menuItems = if (level == MenuLevel.ArchiveMenu) mapArchive.mapArchive.keys.toList() else mapArchive.mapArchive[keyForMap]?.mutableMapNotes?.keys?.toList()
        val numPointsInMenu = menuItems?.size ?: 0

        printMenu(level.menuPoint(), menuItems, numPointsInMenu, level == MenuLevel.NoteMenu)

        return when (val pointMenu = readMenu(numPointsInMenu + 1)) {
            0 -> {
                if (level == MenuLevel.ArchiveMenu) {
                    val key = mapArchive.makeArchive()
                    MenuKey.ArchiveKey(key.toString())
                } else {
                    val key = mapArchive.mapArchive[keyForMap]?.makeNote() ?: ""
                    MenuKey.NoteKey(key.toString())
                }
            }
            numPointsInMenu + 1 -> {
                if (level == MenuLevel.ArchiveMenu) MenuKey.ExitApp else MenuKey.ExitMenu
            }
            else -> {
                val key = menuItems?.get(pointMenu - 1) ?: ""
                if (level == MenuLevel.ArchiveMenu) MenuKey.ArchiveKey(key) else MenuKey.NoteKey(key)
            }
        }
    }

    private fun printMenu(menuPoint: String, menuItems: List<String>?, numPoints: Int, isNoteMenu: Boolean) {
        println("0. $menuPoint")
        menuItems?.forEachIndexed { index, item -> println("${index + 1}. $item") }
        println("${numPoints + 1}. ${if(isNoteMenu) "Возврат в предыдущее меню" else "Выход из программы"}")
    }

    fun readMenu(numPoints: Int): Int {
        while (true) {
            val input = readLine()?.toIntOrNull()
            if (input != null && input in 0..numPoints) {
                return input
            } else {
                println("Введите число от 0 до $numPoints!")
            }
        }
    }
}