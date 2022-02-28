package videos;

public class Channel {

    private String channelName;
    private int numberOfSubscribers;
    private int numberOfVideos;

    public Channel(String channelName, int numberOfSubscribers, int numberOfVideos) {
        this.channelName = channelName;
        this.numberOfSubscribers = numberOfSubscribers;
        this.numberOfVideos = numberOfVideos;
    }

    public String getChannelName() {
        return channelName;
    }

    public int getNumberOfSubscribers() {
        return numberOfSubscribers;
    }

    public int getNumberOfVideos() {
        return numberOfVideos;
    }

}

