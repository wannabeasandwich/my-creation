package cn.tedu.cache;

public enum CacheEnum {
    /**
     * 缓存1
     */
    CACHE1(CacheConstants.CACHE1, CacheConstants.EXPIRES_5_MIN),
    /**
     * 缓存2
     */
    CACHE2(CacheConstants.CACHE2, CacheConstants.EXPIRES_10_MIN),
    ;
    /*
     * 缓存名称
     */
    private final String name;
    /*
     * 过期时间
     */
    private final int expires;

    /*
     * 构造
     */
    CacheEnum(String name, int expires) {
        this.name = name;
        this.expires = expires;
    }

    public String getName() {
        return name;
    }

    public int getExpires() {
        return expires;
    }
}
