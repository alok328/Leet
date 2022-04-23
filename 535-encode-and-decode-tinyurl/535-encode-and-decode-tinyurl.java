public class Codec {
    
    Map<String, String> encoding;
    String baseUrl = "http://tinyurl.com/";
    
    public Codec() {
        this.encoding = new HashMap<>();
    }
    
    private String getHashCode(String url) {
        return String.valueOf(url.hashCode());
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String hash = getHashCode(longUrl);
        encoding.put(baseUrl + hash, longUrl);
        return baseUrl + hash;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return encoding.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));