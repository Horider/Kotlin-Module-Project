class MapNotes(val mutableMapNotes: MutableMap<String, String>) {

    fun makeNote() {
        var keyNote: String?
        var note: String?

        do {
            print("Введите название заметки: ")
            keyNote = readLine()?.trim()
            if (keyNote == null || keyNote.isEmpty()) {
                println("Некорректный ввод. Название заметки не может быть пустым.")
                println(" ")
            }
        } while (keyNote == null || keyNote.isEmpty())

        do {
            print("Введите содержание заметки: ")
            note = readLine()?.trim()
            if (note == null || note.isEmpty()) {
                println("Некорректный ввод. Содержание заметки не может быть пустым.")
                println(" ")
            }
        } while (note == null || note.isEmpty())

        addMapNotes(keyNote, note)
        println("Заметка добавлена")
        println("Теперь заметок: ${mutableMapNotes.size}")
        println(" ")
    }

    fun deleteNote(keyNote: String) {
        mutableMapNotes.remove(keyNote)
    }

    private fun addMapNotes(keyNote: String, note: String) {
        mutableMapNotes[keyNote] = note
    }
}
