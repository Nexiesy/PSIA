# PSIA
https://minecraftpocket-servers.com/ allows you to get information about servers on the site.

# How does it work?

```java
PSIA psia = new PSIA("https://minecraftpocket-servers.com/server/89317/");
PSIAServer server = psia.getServer();
```

# All Functions 💻

### About 📖
| Function | Information | Returning data type |
|:-----------:|:----------:|:----------:|
| getAddress | Allows you to get the server address. | String |
| getHostname | Allows you to get a host name. | String |
| getStatus | You will receive information about the server status. | String |
| getPlayers | You will see the number of online players. | String |
| getLocation | Returns server location. | String |
| getVersion | Returns the server version. | String |
| getWebsite | Shows server site. | String |
| getAllPlayers | You see all active players. | List |

### Statistics 📈
| Function | Information | Returning data type |
|:-----------:|:----------:|:----------:|
| getUptime | See how long the server has been active. | String |
| getVote | Shows the number of votes cast to the server. | Integer |
| getRank | See where in the rankings. | Integer |
| getScore | Gives you how many points the server has. | Integer |
| getFavorited | You will see how many people have added the server to their favorites. | Integer |
| getDiscussion | See how many discussions are opened. | Integer |

# Maven repository


```xml
    <dependency>
        <groupId>net.nexiesy</groupId>
        <artifactId>PSIA</artifactId>
        <version>0.0.1</version>
    </dependency>
```
