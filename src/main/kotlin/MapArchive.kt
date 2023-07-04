class MapArchive(val mapArchive: MutableMap<String, MapNotes>) {

    fun makeArchive() {
        var keyArchive: String?

        do {
            print("Введите название архива: ")
            keyArchive = readLine()?.trim()
            if (keyArchive == null || keyArchive.isEmpty()) {
                println("Некорректный ввод. Название архива не может быть пустым.")
                println(" ")
            }
        } while (keyArchive == null || keyArchive.isEmpty())

        addMapNoteToArchive(keyArchive)
        println("Архив создан\n")
        println("Теперь количество архивов стало ${mapArchive.size}\n")
    }

    private fun addMapNoteToArchive(keyArchive: String) {
        val mapNotesInArchive = MapNotes(mutableMapOf())
        mapArchive[keyArchive] = mapNotesInArchive
    }
}
