package com.shubha.SpotifyAutomation;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SpotifyAutomation {
    static String token="BQDSwKE3k0KAvCmI49J_05uR-mlBboPVMS6Qe5AkDOGm7rY2YJpkpYBP9jkVuLXNqIe-d6w_hYvSiYFxilb-sneTSrybaVVytbSB5hWRsQ5b5jKSiNBvZIX-YEk5R0ok6Osp4QzAKRLySp-97d-FixE4OR345lhxHnFkPipUtzFf7ykRq9KQ9T7IwSzuCp2wy6PydkanYT6IZEOb9SlUElDoJgv2ZYUn4pab8d1T8Rex0e8iP2y_Ue-sohVEDM3a0m3LqMKt3ho7Js9bvK2t6md6bU2RiOFKqIwSc6rjsFlpDRm_07QxLX0bQj1H-UyUYBju5Mr1X6Bv&token_type=Bearer&expires_in=3600&state=state";
    static String userId="31434j7zt3mwkorhzibso2njmf5y";
    static String albumId="0TnOYISbd1XYRBk9myaseg";

    /* User starts */

    @Test(priority = 1)
    public void getCurrentUserProfile(){
        Response response=given()
                .header("Content-Type", "application/josn")
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/me");
        response.prettyPrint();
        response.then().statusCode(200);
        userId=response.path("id");
    }

    @Test(priority = 3)
    public void getUsersTopItem(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/me/top/artists");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test(priority = 2)
    public void getUsersProfile(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                // .pathParam("user_id",userId)
                .when()
                .get("https://api.spotify.com/v1/users/"+ userId);
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test(priority = 4)
    public void followPlaylist(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .pathParam("playlistid","3cEYpjA9oz9GiPac4AsH4n")
                .body("{\n" +
                        "    \"public\": false\n" +
                        "}")
                .when()
                .put("https://api.spotify.com/v1/playlists/{playlistid}/followers");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test(priority = 6)
    public void unfollowPlaylist(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .pathParam("playlistid","3cEYpjA9oz9GiPac4AsH4n")
                .body("{\n" +
                        "    \"public\": false\n" +
                        "}")
                .when()
                .delete("https://api.spotify.com/v1/playlists/{playlistid}/followers");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test(priority = 5)
    public void getFollowedArtist(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("type","artist")
                .when()
                .get("https://api.spotify.com/v1/me/following");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test(priority = 7)
    public void followArtistOrUsers(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("type","artist")
                .queryParam("ids","2CIMQHirSU0MQqyYHq0eOx," +
                        "57dN52uHvrHOxijzpIgu3E,1vCWHaC5f2uS3yhpwWbIA6")
                .when()
                .put("https://api.spotify.com/v1/me/following");
        response.prettyPrint();
        response.then().statusCode(204);
    }

    @Test(priority = 9)
    public void unFollowArtistOrUsers(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("type","artist")
                .queryParam("ids","2CIMQHirSU0MQqyYHq0eOx,57dN52uHvrHOxijzpIgu3E,1vCWHaC5f2uS3yhpwWbIA6")
                .when()
                .delete("https://api.spotify.com/v1/me/following/");
        response.prettyPrint();
        response.then().statusCode(204);
    }

    @Test(priority = 8)
    public void checkIfUserFollowsArtistsorUsers(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("type","artist")
                .queryParam("ids","2CIMQHirSU0MQqyYHq0eOx,57dN52uHvrHOxijzpIgu3E,1vCWHaC5f2uS3yhpwWbIA6")
                .when()
                .get("https://api.spotify.com/v1/me/following/contains");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test(priority = 10)
    public void checkifUsersFollowPlaylist(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("ids","jmperezperez,thelinmichael,wizzler")
                .pathParam("playlistid","3cEYpjA9oz9GiPac4AsH4n")
                .when()
                .get("https://api.spotify.com/v1/playlists/{playlistid}/followers/contains");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    /* User Ends*/

    /* Album starts */

    @Test(priority = 11)
    public void getAlbum(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .pathParam("id","4aawyAB9vmqN3uQ7FjRGTy")
                .when()
                .get("https://api.spotify.com/v1/albums/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
        albumId=response.path("id");
    }
    @Test
    public void getSeveralAlbum(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("ids","382ObEPsp2rxGrnsizN5TX,1A2GTWGtFfWp7KSQTwWOyo,2noRn2Aes5aoNVsU6iWThc")
                .when()
                .get("https://api.spotify.com/v1/albums");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test(priority = 12)
    public void getAlbumTracks(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .pathParam("id", albumId)
                .when()
                .get("https://api.spotify.com/v1/albums/{id}/tracks");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void getUsersSavedAlbums(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("offsest",0)
                .queryParam("limit",20)
                .when()
                .get("https://api.spotify.com/v1/me/albums");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public  void saveAlbumsForCurrentUser(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("ids","382ObEPsp2rxGrnsizN5TX,1A2GTWGtFfWp7KSQTwWOyo,2noRn2Aes5aoNVsU6iWThc")
                .when()
                .put("https://api.spotify.com/v1/me/albums");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public  void deleteSavedAlbumsForCurrentUser(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("ids","382ObEPsp2rxGrnsizN5TX,1A2GTWGtFfWp7KSQTwWOyo,2noRn2Aes5aoNVsU6iWThc")
                .when()
                .delete("https://api.spotify.com/v1/me/albums");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void checkUsersSavedAlbums(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("ids","382ObEPsp2rxGrnsizN5TX,1A2GTWGtFfWp7KSQTwWOyo,2noRn2Aes5aoNVsU6iWThc")
                .when()
                .get("https://api.spotify.com/v1/me/albums/contains");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void getNewReleases(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/browse/new-releases");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    /* Albums Ends */

    /* Artist Starts */

    @Test
    public void getArtist(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .pathParam("id","0TnOYISbd1XYRBk9myaseg")
                .when()
                .get("https://api.spotify.com/v1/artists/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void getSeveralArtist(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("ids","2CIMQHirSU0MQqyYHq0eOx,57dN52uHvrHOxijzpIgu3E,1vCWHaC5f2uS3yhpwWbIA6")
                .when()
                .get("https://api.spotify.com/v1/artists");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void getArtistAlbums(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .pathParam("id","0TnOYISbd1XYRBk9myaseg")
                .when()
                .get("https://api.spotify.com/v1/artists/{id}/albums");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void GetArtistsTopTracks(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .pathParam("id","0TnOYISbd1XYRBk9myaseg")
                .when()
                .get("https://api.spotify.com/v1/artists/{id}/top-tracks");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void getArtistsRelatedArtists(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .pathParam("id","0TnOYISbd1XYRBk9myaseg")
                .when()
                .get("https://api.spotify.com/v1/artists/{id}/related-artists");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void getAnAudioBook(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .pathParam("id","7iHfbu1YPACw6oZPAFJtqe")
                .when()
                .get("https://api.spotify.com/v1/audiobooks/{id}");
        response.prettyPrint();
        response.then().statusCode(404);
    }

    @Test
    public void getSeveralAudiobooks(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("ids","18yVqkdbdRvS24c0Ilj2ci,1HGw3J3NxZO1TP1BTtVhpZ,7iHfbu1YPACw6oZPAFJtqe")
                .when()
                .get("https://api.spotify.com/v1/audiobooks");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void getAudiobookChapters(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .pathParam("id","7iHfbu1YPACw6oZPAFJtqe")
                .when()
                .get("https://api.spotify.com/v1/audiobooks/{id}/chapters");
        response.prettyPrint();
        response.then().statusCode(404);
    }

    @Test
    public void getUsersSavedAudiobooks(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/me/audiobooks");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void saveAudiobooksforCurrentUser(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("ids","18yVqkdbdRvS24c0Ilj2ci,1HGw3J3NxZO1TP1BTtVhpZ,7iHfbu1YPACw6oZPAFJtqe")
                .when()
                .put("https://api.spotify.com/v1/me/audiobooks");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void removeSavedAudiobooksforCurrentUser(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("ids","18yVqkdbdRvS24c0Ilj2ci,1HGw3J3NxZO1TP1BTtVhpZ,7iHfbu1YPACw6oZPAFJtqe")
                .when()
                .delete("https://api.spotify.com/v1/me/audiobooks");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void checkSavedAudiobooksforCurrentUser(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("ids","18yVqkdbdRvS24c0Ilj2ci,1HGw3J3NxZO1TP1BTtVhpZ,7iHfbu1YPACw6oZPAFJtqe")
                .when()
                .get("https://api.spotify.com/v1/me/audiobooks/contains");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    /* AudioBooks Ends */

    /* Category starts*/

    @Test
    public void getSeveralBrowseCategories(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/browse/categories");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void getSingleBrowseCategory(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .pathParam("category_id","dinner")
                .when()
                .get("https://api.spotify.com/v1/browse/categories/{category_id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    /* Category ends */

    /* Chapter starts */

    @Test
    public void getAChapter(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .pathParam("id","0D5wENdkdwbqlrHoaJ9g29")
                .when()
                .get("https://api.spotify.com/v1/chapters/{id}");
        response.prettyPrint();
        response.then().statusCode(404);
    }

    @Test
    public void getSeveralChapters(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("ids","0IsXVP0JmcB2adSE338GkK,3ZXb8FKZGU0EHALYX6uCzU,0D5wENdkdwbqlrHoaJ9g29")
                .when()
                .get("https://api.spotify.com/v1/chapters");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    /* Chapter Ends*/

    /* Episode Starts*/

    @Test
    public void getEpisode(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .pathParam("id","512ojhOuo1ktJprKbVcKyQ")
                .when()
                .get("https://api.spotify.com/v1/episodes/{id}");
        response.prettyPrint();
        response.then().statusCode(404);
    }

    @Test
    public void getSeveralEpisode(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("ids","77o6BIVlYM3msb4MMIL1jH,0Q86acNRm6V9GYx55SXKwf")
                .when()
                .get("https://api.spotify.com/v1/episodes");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void getUserSavedEpisodes(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/me/episodes");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void saveEpisodesforCurrentUser(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("ids","77o6BIVlYM3msb4MMIL1jH,0Q86acNRm6V9GYx55SXKwf")
                .when()
                .put("https://api.spotify.com/v1/me/episodes");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void removeSavedEpisodesForCurrentUser(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("ids","77o6BIVlYM3msb4MMIL1jH,0Q86acNRm6V9GYx55SXKwf")
                .when()
                .delete("https://api.spotify.com/v1/me/episodes");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void checkUsersSavedEpisodes(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("ids","77o6BIVlYM3msb4MMIL1jH,0Q86acNRm6V9GYx55SXKwf")
                .when()
                .get("https://api.spotify.com/v1/me/episodes/contains");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    /* Episode Ends */


    @Test
    public void getAvailableGenreSeeds(){
        Response response=given()
                .header("Content-Type", "application/josn")
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/recommendations/available-genre-seeds");
        response.prettyPrint();
        response.then().statusCode(200);
        userId=response.path("id");
    }

@Test
    public void getAvailableMarkets(){
    Response response=given()
            .header("Content-Type", "application/josn")
            .header("Authorization","Bearer "+token)
            .when()
            .get("https://api.spotify.com/v1/markets");
    response.prettyPrint();
    response.then().statusCode(200);
    userId=response.path("id");
    }

    @Test
    public void getPlaybackState(){
        Response response=given()
                .header("Content-Type", "application/josn")
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/me/player");
        response.prettyPrint();
        response.then().statusCode(204);
    }

    @Test
    public void TransferPlayback(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .when()
                .put("https://api.spotify.com/v1/me/player");
        response.prettyPrint();
        response.then().statusCode(403);
    }

    @Test
    public void getAvailableDevices(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/me/player/device");
        response.prettyPrint();
        response.then().statusCode(404);
    }

    @Test
    public void getCurrentlyPlayingTrack(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/me/player/currently-playing ");
        response.prettyPrint();
        response.then().statusCode(204);
    }

    @Test
    public void StartorResumePlayback(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("ids","5ht7ItJgpBH7W6vJ5BqpPr")
                .when()
                .put("https://api.spotify.com/v1/me/player/play");
        response.prettyPrint();
        response.then().statusCode(403);
    }

    @Test
    public void pausePlayback(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("ids","5ht7ItJgpBH7W6vJ5BqpPr")
                .when()
                .put("https://api.spotify.com/v1/me/player/pause");
        response.prettyPrint();
        response.then().statusCode(403);
    }

    @Test
    public void skipToNext(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .when()
                .post("https://api.spotify.com/v1/me/player/next");
        response.prettyPrint();
        response.then().statusCode(403);
    }

    @Test
    public void skipToPrevious(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .when()
                .post("https://api.spotify.com/v1/me/player/previous");
        response.prettyPrint();
        response.then().statusCode(403);
    }


    @Test
    public void SeektoPosition(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("ids","5ht7ItJgpBH7W6vJ5BqpPr")
                .when()
                .put("https://api.spotify.com/v1/me/player/seek?position_ms=25000");
        response.prettyPrint();
        response.then().statusCode(403);
    }

    @Test
    public void setRepeatMode(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("ids","5ht7ItJgpBH7W6vJ5BqpPr")
                .when()
                .put("https://api.spotify.com/v1/me/player/repeat?state=context");
        response.prettyPrint();
        response.then().statusCode(403);
    }

    @Test
    public void setPlaybackVolume(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("ids","5ht7ItJgpBH7W6vJ5BqpPr")
                .when()
                .put("https://api.spotify.com/v1/me/player/volume?volume_percent=50");
        response.prettyPrint();
        response.then().statusCode(403);
    }

    @Test
    public void togglePlaybackShuffle(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("ids","5ht7ItJgpBH7W6vJ5BqpPr")
                .when()
                .put("https://api.spotify.com/v1/me/player/shuffle?state=true");
        response.prettyPrint();
        response.then().statusCode(403);
    }

    @Test
    public void getRecentlyPlayedTracks(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/me/player/recently-played ");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void getTheusersQueue(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/me/player/queue");
        response.prettyPrint();
        response.then().statusCode(403);
    }

    @Test
    public void addItemtoPlaybackQueue(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .when()
                .post("https://api.spotify.com/v1/me/player/queue?uri=spotify%3Atrack%3A4iV5W9uYEdYUVa79Axb7Rh'");
        response.prettyPrint();
        response.then().statusCode(403);
    }

    @Test
    public void getPlayList(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void changePlaylistDetails(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("ids","5ht7ItJgpBH7W6vJ5BqpPr")
                .when()
                .put("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n");
        response.prettyPrint();
        response.then().statusCode(403);
    }

    @Test
    public void getPlaylistItems(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/tracks");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void updatePlaylistItems(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("ids","5ht7ItJgpBH7W6vJ5BqpPr")
                .when()
                .put("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/tracks");
        response.prettyPrint();
        response.then().statusCode(400);
    }

    @Test
    public void addItemstoPlaylist(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .when()
                .post("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/tracks");
        response.prettyPrint();
        response.then().statusCode(403);
    }

    @Test
    public void removePlaylistItems(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .body("{\n" +
                        "    \"public\": false\n" +
                        "}")
                .when()
                .delete("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/tracks");
        response.prettyPrint();
        response.then().statusCode(400);
    }

    @Test
    public void getcurrentUsersPlaylist(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("type","artist")
                .when()
                .get("https://api.spotify.com/v1/me/playlists");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void getUsersPlaylists(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("type","artist")
                .when()
                .get("https://api.spotify.com/v1/users/smedjan/playlists");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void createPlaylist(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .when()
                .post("https://api.spotify.com/v1/users/smedjan/playlists");
        response.prettyPrint();
        response.then().statusCode(403);
    }

    @Test
    public void getFeaturedPlaylists(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("type","artist")
                .when()
                .get("https://api.spotify.com/v1/browse/featured-playlists");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void getCategorysPlaylists(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("type","artist")
                .when()
                .get("https://api.spotify.com/v1/browse/categories/dinner/playlists");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void getPlaylistCoverImage(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("type","artist")
                .when()
                .get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/images");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void addCustomPlaylistCoverImage(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("type","artist")
                .queryParam("ids","2CIMQHirSU0MQqyYHq0eOx," +
                        "57dN52uHvrHOxijzpIgu3E,1vCWHaC5f2uS3yhpwWbIA6")
                .when()
                .put("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/images");
        response.prettyPrint();
        response.then().statusCode(401);
    }

    @Test
    public void searchForItem(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("type","artist")
                .when()
                .get("https://api.spotify.com/v1/search?q=remaster%2520track%3ADoxy%2520artist%3AMiles%2520Davis&type=album");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void getShow(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("type","artist")
                .when()
                .get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ ");
        response.prettyPrint();
        response.then().statusCode(404);
    }

    @Test
    public void getSeveralShows(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("type","artist")
                .when()
                .get("https://api.spotify.com/v1/shows?ids=5CfCWKI5pZ28U0uOzXkDHe%2C5as3aKmN2k11yfDDDSrvaZ");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void getShowEpisodes(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("type","artist")
                .when()
                .get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ/episodes");
        response.prettyPrint();
        response.then().statusCode(404);
    }

    @Test
    public void getUsersSavedShows(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("type","artist")
                .when()
                .get("https://api.spotify.com/v1/me/shows");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void saveShowsForCurrentUser(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("type","artist")
                .queryParam("ids","2CIMQHirSU0MQqyYHq0eOx," +
                        "57dN52uHvrHOxijzpIgu3E,1vCWHaC5f2uS3yhpwWbIA6")
                .when()
                .put("https://api.spotify.com/v1/me/shows?ids=5CfCWKI5pZ28U0uOzXkDHe%2C5as3aKmN2k11yfDDDSrvaZ");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void removeUsersSavedShows(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("type","artist")
                .queryParam("ids","2CIMQHirSU0MQqyYHq0eOx,57dN52uHvrHOxijzpIgu3E,1vCWHaC5f2uS3yhpwWbIA6")
                .when()
                .delete("https://api.spotify.com/v1/me/shows?ids=5CfCWKI5pZ28U0uOzXkDHe%2C5as3aKmN2k11yfDDDSrvaZ");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void checkUsersSavedShows(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("type","artist")
                .when()
                .get("https://api.spotify.com/v1/me/shows/contains?ids=5CfCWKI5pZ28U0uOzXkDHe%2C5as3aKmN2k11yfDDDSrvaZ");
        response.prettyPrint();
        response.then().statusCode(400);
    }

    @Test
    public void getTrack(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("type","artist")
                .when()
                .get("https://api.spotify.com/v1/tracks/11dFghVXANMlKmJXsNCbNl");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void getSeveralTracks(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("type","artist")
                .when()
                .get("https://api.spotify.com/v1/tracks?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void getUsersSavedTracks(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("type","artist")
                .when()
                .get("https://api.spotify.com/v1/me/tracks");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void saveTracksforCurrentUser(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("ids","382ObEPsp2rxGrnsizN5TX,1A2GTWGtFfWp7KSQTwWOyo,2noRn2Aes5aoNVsU6iWThc")
                .when()
                .put("https://api.spotify.com/v1/me/tracks?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void removeUserssavedTracks(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("ids","382ObEPsp2rxGrnsizN5TX,1A2GTWGtFfWp7KSQTwWOyo,2noRn2Aes5aoNVsU6iWThc")
                .when()
                .delete("https://api.spotify.com/v1/me/tracks?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void checkUsersSavedTracks(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("type","artist")
                .when()
                .get("https://api.spotify.com/v1/me/tracks/contains?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
        response.prettyPrint();
        response.then().statusCode(400);
    }

    @Test
    public void getSeveralTracksAudioFeatures(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("type","artist")
                .when()
                .get("https://api.spotify.com/v1/audio-features?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void getTrackAudiosFeatures(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("type","artist")
                .when()
                .get("https://api.spotify.com/v1/audio-features/11dFghVXANMlKmJXsNCbNl");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void getTrackAudiosAnalysis(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("type","artist")
                .when()
                .get("https://api.spotify.com/v1/audio-analysis/11dFghVXANMlKmJXsNCbNl");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void getRecommendations(){
        Response response=given()
                .header("Content-Type","application/json")
                .header("authorization","Bearer "+token)
                .queryParam("type","artist")
                .when()
                .get("https://api.spotify.com/v1/recommendations?seed_artists=4NHQUGzhtTLFvgF5SZesLK&seed_genres=classical%2Ccountry&seed_tracks=0c6xIDDpzE81m2q797ordA");
        response.prettyPrint();
        response.then().statusCode(200);
    }


}
