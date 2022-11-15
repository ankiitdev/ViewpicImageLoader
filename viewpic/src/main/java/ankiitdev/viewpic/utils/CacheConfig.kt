package ankiitdev.viewpic.utils

class CacheConfig {
    companion object {
        val maxMemory = Runtime.getRuntime().maxMemory() /1024
        val defaultCacheSize = (maxMemory /4).toInt()
    }
}