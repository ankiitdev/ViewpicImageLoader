package ankiitdev.viewpic.cache

import android.graphics.Bitmap
import android.util.Log
import androidx.collection.LruCache
import ankiitdev.viewpic.utils.CacheConfig

class MemoryCache constructor(newMaxSize: Int): ImageCache {

    private val cache: LruCache<String, Bitmap>

    init {
        val cacheSize : Int = if (newMaxSize > CacheConfig.maxMemory) {
            CacheConfig.defaultCacheSize
                Log.d("memory_cache","New value of cache is bigger than maximum cache available on system")
        } else {
            newMaxSize
        }
        cache = object : LruCache<String, Bitmap>(cacheSize) {
            override fun sizeOf(key: String, value: Bitmap): Int {
                return (value.rowBytes)*(value.height)/1024
            }
        }
    }

    override fun addImage(url: String, bitmap: Bitmap) {
        cache.put(url, bitmap)
    }

    override fun getImage(url: String): Bitmap? {
        return cache.get(url)
    }

    override fun clearImages() {
        cache.evictAll()
    }
}