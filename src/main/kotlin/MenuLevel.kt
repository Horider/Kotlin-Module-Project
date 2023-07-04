enum class MenuLevel(val levelName: String) {
    MainMenu("Главное меню"),
    ArchiveMenu("Архив"),
    NoteMenu("Заметки");

    fun menuPoint(): String {
        return when (this) {
            MainMenu -> "Главное меню"
            ArchiveMenu -> "Создать архив"
            NoteMenu -> "Создать заметку"
        }
    }
}