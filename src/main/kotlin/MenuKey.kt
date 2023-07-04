sealed interface MenuKey {
    data class ArchiveKey(val key: String): MenuKey
    data class NoteKey(val key: String): MenuKey
    object ExitApp : MenuKey
    object ExitMenu : MenuKey
    object ArchiveCreated : MenuKey
    object NoteCreated : MenuKey
}