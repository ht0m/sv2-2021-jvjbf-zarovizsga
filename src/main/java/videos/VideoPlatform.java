package videos;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VideoPlatform {

    private static final String SEPARATOR =";" ;
    List<Channel> channels = new ArrayList<>();

    public void readDataFromFile(Path path) {
        try(Scanner scanner = new Scanner(path)) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
             String [] parts = scanner.nextLine().split(SEPARATOR);
             channels.add(new Channel(parts[0],Integer.parseInt(parts[1]),Integer.parseInt(parts[2])));
            }
        }catch (IOException ioException) {
            throw new IllegalArgumentException("Cannot open file for read!",ioException);
        }
    }

    public int calculateSumOfVideos() {
        return channels.stream()
                .mapToInt(channel -> channel.getNumberOfVideos())
                .sum();
    }

    public List<Channel> getChannels() {
        return new ArrayList<>(channels);
    }
}
