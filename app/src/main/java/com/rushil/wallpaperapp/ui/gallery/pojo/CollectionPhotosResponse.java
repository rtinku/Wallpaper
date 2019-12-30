package com.rushil.wallpaperapp.ui.gallery.pojo;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CollectionPhotosResponse implements Parcelable {

    public final static Parcelable.Creator<CollectionPhotosResponse> CREATOR = new Creator<CollectionPhotosResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CollectionPhotosResponse createFromParcel(Parcel in) {
            return new CollectionPhotosResponse(in);
        }

        public CollectionPhotosResponse[] newArray(int size) {
            return (new CollectionPhotosResponse[size]);
        }

    };
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("promoted_at")
    @Expose
    public String promotedAt;
    @SerializedName("width")
    @Expose
    public Integer width;
    @SerializedName("height")
    @Expose
    public Integer height;
    @SerializedName("color")
    @Expose
    public String color;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("alt_description")
    @Expose
    public String altDescription;
    @SerializedName("urls")
    @Expose
    public Urls urls;
    @SerializedName("links")
    @Expose
    public Links links;
    @SerializedName("categories")
    @Expose
    public List<Object> categories = null;
    @SerializedName("likes")
    @Expose
    public Integer likes;
    @SerializedName("liked_by_user")
    @Expose
    public Boolean likedByUser;
    @SerializedName("current_user_collections")
    @Expose
    public List<Object> currentUserCollections = null;
    @SerializedName("user")
    @Expose
    public User user;

    protected CollectionPhotosResponse(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.promotedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.width = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.height = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.color = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.altDescription = ((String) in.readValue((String.class.getClassLoader())));
        this.urls = ((Urls) in.readValue((Urls.class.getClassLoader())));
        this.links = ((Links) in.readValue((Links.class.getClassLoader())));
        in.readList(this.categories, (java.lang.Object.class.getClassLoader()));
        this.likes = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.likedByUser = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        in.readList(this.currentUserCollections, (java.lang.Object.class.getClassLoader()));
        this.user = ((User) in.readValue((User.class.getClassLoader())));
    }

    public CollectionPhotosResponse() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(promotedAt);
        dest.writeValue(width);
        dest.writeValue(height);
        dest.writeValue(color);
        dest.writeValue(description);
        dest.writeValue(altDescription);
        dest.writeValue(urls);
        dest.writeValue(links);
        dest.writeList(categories);
        dest.writeValue(likes);
        dest.writeValue(likedByUser);
        dest.writeList(currentUserCollections);
        dest.writeValue(user);
    }

    public int describeContents() {
        return 0;
    }

    public static class User implements Parcelable {

        public final static Parcelable.Creator<User> CREATOR = new Creator<User>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public User createFromParcel(Parcel in) {
                return new User(in);
            }

            public User[] newArray(int size) {
                return (new User[size]);
            }

        };
        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("updated_at")
        @Expose
        public String updatedAt;
        @SerializedName("username")
        @Expose
        public String username;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("first_name")
        @Expose
        public String firstName;
        @SerializedName("last_name")
        @Expose
        public String lastName;
        @SerializedName("twitter_username")
        @Expose
        public Object twitterUsername;
        @SerializedName("portfolio_url")
        @Expose
        public String portfolioUrl;
        @SerializedName("bio")
        @Expose
        public String bio;
        @SerializedName("location")
        @Expose
        public String location;
        @SerializedName("links")
        @Expose
        public Links_ links;
        @SerializedName("profile_image")
        @Expose
        public ProfileImage profileImage;
        @SerializedName("instagram_username")
        @Expose
        public String instagramUsername;
        @SerializedName("total_collections")
        @Expose
        public Integer totalCollections;
        @SerializedName("total_likes")
        @Expose
        public Integer totalLikes;
        @SerializedName("total_photos")
        @Expose
        public Integer totalPhotos;
        @SerializedName("accepted_tos")
        @Expose
        public Boolean acceptedTos;

        protected User(Parcel in) {
            this.id = ((String) in.readValue((String.class.getClassLoader())));
            this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
            this.username = ((String) in.readValue((String.class.getClassLoader())));
            this.name = ((String) in.readValue((String.class.getClassLoader())));
            this.firstName = ((String) in.readValue((String.class.getClassLoader())));
            this.lastName = ((String) in.readValue((String.class.getClassLoader())));
            this.twitterUsername = in.readValue((Object.class.getClassLoader()));
            this.portfolioUrl = ((String) in.readValue((String.class.getClassLoader())));
            this.bio = ((String) in.readValue((String.class.getClassLoader())));
            this.location = ((String) in.readValue((String.class.getClassLoader())));
            this.links = ((Links_) in.readValue((Links_.class.getClassLoader())));
            this.profileImage = ((ProfileImage) in.readValue((ProfileImage.class.getClassLoader())));
            this.instagramUsername = ((String) in.readValue((String.class.getClassLoader())));
            this.totalCollections = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.totalLikes = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.totalPhotos = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.acceptedTos = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        }

        public User() {
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(id);
            dest.writeValue(updatedAt);
            dest.writeValue(username);
            dest.writeValue(name);
            dest.writeValue(firstName);
            dest.writeValue(lastName);
            dest.writeValue(twitterUsername);
            dest.writeValue(portfolioUrl);
            dest.writeValue(bio);
            dest.writeValue(location);
            dest.writeValue(links);
            dest.writeValue(profileImage);
            dest.writeValue(instagramUsername);
            dest.writeValue(totalCollections);
            dest.writeValue(totalLikes);
            dest.writeValue(totalPhotos);
            dest.writeValue(acceptedTos);
        }

        public int describeContents() {
            return 0;
        }

        public static class ProfileImage implements Parcelable {

            public final static Parcelable.Creator<ProfileImage> CREATOR = new Creator<ProfileImage>() {


                @SuppressWarnings({
                        "unchecked"
                })
                public ProfileImage createFromParcel(Parcel in) {
                    return new ProfileImage(in);
                }

                public ProfileImage[] newArray(int size) {
                    return (new ProfileImage[size]);
                }

            };
            @SerializedName("small")
            @Expose
            public String small;
            @SerializedName("medium")
            @Expose
            public String medium;
            @SerializedName("large")
            @Expose
            public String large;

            protected ProfileImage(Parcel in) {
                this.small = ((String) in.readValue((String.class.getClassLoader())));
                this.medium = ((String) in.readValue((String.class.getClassLoader())));
                this.large = ((String) in.readValue((String.class.getClassLoader())));
            }

            public ProfileImage() {
            }

            public void writeToParcel(Parcel dest, int flags) {
                dest.writeValue(small);
                dest.writeValue(medium);
                dest.writeValue(large);
            }

            public int describeContents() {
                return 0;
            }

        }

        public static class Links_ implements Parcelable {

            public final static Parcelable.Creator<Links_> CREATOR = new Creator<Links_>() {


                @SuppressWarnings({
                        "unchecked"
                })
                public Links_ createFromParcel(Parcel in) {
                    return new Links_(in);
                }

                public Links_[] newArray(int size) {
                    return (new Links_[size]);
                }

            };
            @SerializedName("self")
            @Expose
            public String self;
            @SerializedName("html")
            @Expose
            public String html;
            @SerializedName("photos")
            @Expose
            public String photos;
            @SerializedName("likes")
            @Expose
            public String likes;
            @SerializedName("portfolio")
            @Expose
            public String portfolio;
            @SerializedName("following")
            @Expose
            public String following;
            @SerializedName("followers")
            @Expose
            public String followers;

            protected Links_(Parcel in) {
                this.self = ((String) in.readValue((String.class.getClassLoader())));
                this.html = ((String) in.readValue((String.class.getClassLoader())));
                this.photos = ((String) in.readValue((String.class.getClassLoader())));
                this.likes = ((String) in.readValue((String.class.getClassLoader())));
                this.portfolio = ((String) in.readValue((String.class.getClassLoader())));
                this.following = ((String) in.readValue((String.class.getClassLoader())));
                this.followers = ((String) in.readValue((String.class.getClassLoader())));
            }

            public Links_() {
            }

            public void writeToParcel(Parcel dest, int flags) {
                dest.writeValue(self);
                dest.writeValue(html);
                dest.writeValue(photos);
                dest.writeValue(likes);
                dest.writeValue(portfolio);
                dest.writeValue(following);
                dest.writeValue(followers);
            }

            public int describeContents() {
                return 0;
            }

        }

    }

    public static class Urls implements Parcelable {

        public final static Parcelable.Creator<Urls> CREATOR = new Creator<Urls>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Urls createFromParcel(Parcel in) {
                return new Urls(in);
            }

            public Urls[] newArray(int size) {
                return (new Urls[size]);
            }

        };
        @SerializedName("raw")
        @Expose
        public String raw;
        @SerializedName("full")
        @Expose
        public String full;
        @SerializedName("regular")
        @Expose
        public String regular;
        @SerializedName("small")
        @Expose
        public String small;
        @SerializedName("thumb")
        @Expose
        public String thumb;

        protected Urls(Parcel in) {
            this.raw = ((String) in.readValue((String.class.getClassLoader())));
            this.full = ((String) in.readValue((String.class.getClassLoader())));
            this.regular = ((String) in.readValue((String.class.getClassLoader())));
            this.small = ((String) in.readValue((String.class.getClassLoader())));
            this.thumb = ((String) in.readValue((String.class.getClassLoader())));
        }

        public Urls() {
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(raw);
            dest.writeValue(full);
            dest.writeValue(regular);
            dest.writeValue(small);
            dest.writeValue(thumb);
        }

        public int describeContents() {
            return 0;
        }

    }

    public static class Links implements Parcelable {

        public final static Parcelable.Creator<Links> CREATOR = new Creator<Links>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Links createFromParcel(Parcel in) {
                return new Links(in);
            }

            public Links[] newArray(int size) {
                return (new Links[size]);
            }

        };
        @SerializedName("self")
        @Expose
        public String self;
        @SerializedName("html")
        @Expose
        public String html;
        @SerializedName("download")
        @Expose
        public String download;
        @SerializedName("download_location")
        @Expose
        public String downloadLocation;

        protected Links(Parcel in) {
            this.self = ((String) in.readValue((String.class.getClassLoader())));
            this.html = ((String) in.readValue((String.class.getClassLoader())));
            this.download = ((String) in.readValue((String.class.getClassLoader())));
            this.downloadLocation = ((String) in.readValue((String.class.getClassLoader())));
        }

        public Links() {
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(self);
            dest.writeValue(html);
            dest.writeValue(download);
            dest.writeValue(downloadLocation);
        }

        public int describeContents() {
            return 0;
        }

    }
}












