class MapArchive(val mapArchive: MutableMap<String, MapNotes>) {

    fun makeArchive() {
        print("Введите название архива: ")
        val keyArchive = readLine() ?: ""

        addMapNoteToArchive(keyArchive)
        println("Архив создан\n")
        println("Теперь количество архивов стало ${mapArchive.size}\n")
    }

    private fun addMapNoteToArchive(keyArchive: String) {
        val mapNotesInArchive = MapNotes(mutableMapOf())
        mapArchive[keyArchive] = mapNotesInArchive
    }
}
