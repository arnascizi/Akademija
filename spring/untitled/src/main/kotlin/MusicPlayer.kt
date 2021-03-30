class MusicPlayer {
    private var songs: Array<String> = arrayOf()

    fun add(name: String) {
        songs += name
    }

    fun show() {
        for (song in songs) {
            println(song + "\n")
        }
    }

    fun play() {
        println("Playing " + songs[0])
    }
}