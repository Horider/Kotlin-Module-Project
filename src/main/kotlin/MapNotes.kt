class MapNotes(val mutableMapNotes: MutableMap<String, String>) {

    fun makeNote() {
        print("Введите название заметки: ")
        val keyNote = readLine()

        print("Введите содержание заметки: ")
        val note = readLine()

        if (keyNote != null && note != null) {
            addMapNotes(keyNote, note)
            println("Заметка добавлена")
            println("Теперь заметок: ${mutableMapNotes.size}")
            println(" ")
        } else {
            println("Некорректный ввод")
        }
    }

    fun deleteNote(keyNote: String) {
        mutableMapNotes.remove(keyNote)
    }

    private fun addMapNotes(keyNote: String, note: String) {
        mutableMapNotes[keyNote] = note
    }
}
