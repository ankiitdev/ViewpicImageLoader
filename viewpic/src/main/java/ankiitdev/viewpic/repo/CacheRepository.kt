package ankiitdev.viewpic.repo

import android.content.Context
import android.graphics.Bitmap
import ankiitdev.viewpic.cache.DiskCache
import ankiitdev.viewpic.cache.ImageCache
import ankiitdev.viewpic.cache.MemoryCache

class CacheRepository constructor(context: Context, cacheSize: Int): ImageCache {

    private val diskCache = DiskCache.getInstance(context)
    private val memoryCache = MemoryCache(cacheSize)

    override fun addImage(url: String, bitmap: Bitmap) {
        diskCache.addImage(url, bitmap)
        memoryCache.addImage(url, bitmap)
    }

    override fun getImage(url: String): Bitmap? {
        return memoryCache.getImage(url) ?: diskCache.getImage(url)
    }

    override fun clearImages() {
        diskCache.clearImages()
        memoryCache.clearImages()
    }
}