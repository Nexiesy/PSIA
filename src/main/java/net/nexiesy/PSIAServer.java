package net.nexiesy;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class PSIAServer {
    @Getter
    private String address;
    @Getter
    private String hostname;
    @Getter
    private String status;
    @Getter
    private String players;
    @Getter
    private String location;
    @Getter
    private String version;
    @Getter
    private String website;
    @Getter
    private String uptime;
    @Getter
    private int vote;
    @Getter
    private int rank;
    @Getter
    private int score;
    @Getter
    private int favorited;
    @Getter
    private int discussion;
    @Getter
    private List<String> allPlayers;
}
