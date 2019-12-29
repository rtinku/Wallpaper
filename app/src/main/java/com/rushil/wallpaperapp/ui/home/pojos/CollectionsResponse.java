package com.rushil.wallpaperapp.ui.home.pojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CollectionsResponse implements Parcelable {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("published_at")
    @Expose
    public String publishedAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("curated")
    @Expose
    public Boolean curated;
    @SerializedName("featured")
    @Expose
    public Boolean featured;
    @SerializedName("total_photos")
    @Expose
    public Integer totalPhotos;
    @SerializedName("private")
    @Expose
    public Boolean _private;
    @SerializedName("share_key")
    @Expose
    public String shareKey;
    @SerializedName("tags")
    @Expose
    public List<Tag> tags = null;
    @SerializedName("links")
    @Expose
    public Links links;
    @SerializedName("user")
    @Expose
    public User user;
    @SerializedName("cover_photo")
    @Expose
    public CoverPhoto coverPhoto;
    @SerializedName("preview_photos")
    @Expose
    public List<PreviewPhoto> previewPhotos = null;
    public final static Parcelable.Creator<CollectionsResponse> CREATOR = new Creator<CollectionsResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CollectionsResponse createFromParcel(Parcel in) {
            return new CollectionsResponse(in);
        }

        public CollectionsResponse[] newArray(int size) {
            return (new CollectionsResponse[size]);
        }

    };

    protected CollectionsResponse(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.publishedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.curated = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.featured = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.totalPhotos = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this._private = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.shareKey = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.tags, (Tag.class.getClassLoader()));
        this.links = ((Links) in.readValue((Links.class.getClassLoader())));
        this.user = ((User) in.readValue((User.class.getClassLoader())));
        this.coverPhoto = ((CoverPhoto) in.readValue((CoverPhoto.class.getClassLoader())));
        in.readList(this.previewPhotos, (PreviewPhoto.class.getClassLoader()));
    }

    public CollectionsResponse() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(title);
        dest.writeValue(description);
        dest.writeValue(publishedAt);
        dest.writeValue(updatedAt);
        dest.writeValue(curated);
        dest.writeValue(featured);
        dest.writeValue(totalPhotos);
        dest.writeValue(_private);
        dest.writeValue(shareKey);
        dest.writeList(tags);
        dest.writeValue(links);
        dest.writeValue(user);
        dest.writeValue(coverPhoto);
        dest.writeList(previewPhotos);
    }

    public int describeContents() {
        return 0;
    }

    public static class CoverPhoto implements Parcelable {

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
        public Links__ links;
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
        public User_ user;
        public final static Parcelable.Creator<CoverPhoto> CREATOR = new Creator<CoverPhoto>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public CoverPhoto createFromParcel(Parcel in) {
                return new CoverPhoto(in);
            }

            public CoverPhoto[] newArray(int size) {
                return (new CoverPhoto[size]);
            }

        };

        protected CoverPhoto(Parcel in) {
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
            this.links = ((Links__) in.readValue((Links__.class.getClassLoader())));
            in.readList(this.categories, (java.lang.Object.class.getClassLoader()));
            this.likes = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.likedByUser = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            in.readList(this.currentUserCollections, (java.lang.Object.class.getClassLoader()));
            this.user = ((User_) in.readValue((User_.class.getClassLoader())));
        }

        public CoverPhoto() {
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

        public static class User_ implements Parcelable {

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
            public Object portfolioUrl;
            @SerializedName("bio")
            @Expose
            public Object bio;
            @SerializedName("location")
            @Expose
            public Object location;
            @SerializedName("links")
            @Expose
            public Links___ links;
            @SerializedName("profile_image")
            @Expose
            public ProfileImage_ profileImage;
            @SerializedName("instagram_username")
            @Expose
            public Object instagramUsername;
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
            public final static Parcelable.Creator<User_> CREATOR = new Creator<User_>() {


                @SuppressWarnings({
                        "unchecked"
                })
                public User_ createFromParcel(Parcel in) {
                    return new User_(in);
                }

                public User_[] newArray(int size) {
                    return (new User_[size]);
                }

            };

            protected User_(Parcel in) {
                this.id = ((String) in.readValue((String.class.getClassLoader())));
                this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
                this.username = ((String) in.readValue((String.class.getClassLoader())));
                this.name = ((String) in.readValue((String.class.getClassLoader())));
                this.firstName = ((String) in.readValue((String.class.getClassLoader())));
                this.lastName = ((String) in.readValue((String.class.getClassLoader())));
                this.twitterUsername = ((Object) in.readValue((Object.class.getClassLoader())));
                this.portfolioUrl = ((Object) in.readValue((Object.class.getClassLoader())));
                this.bio = ((Object) in.readValue((Object.class.getClassLoader())));
                this.location = ((Object) in.readValue((Object.class.getClassLoader())));
                this.links = ((Links___) in.readValue((Links___.class.getClassLoader())));
                this.profileImage = ((ProfileImage_) in.readValue((ProfileImage_.class.getClassLoader())));
                this.instagramUsername = ((Object) in.readValue((Object.class.getClassLoader())));
                this.totalCollections = ((Integer) in.readValue((Integer.class.getClassLoader())));
                this.totalLikes = ((Integer) in.readValue((Integer.class.getClassLoader())));
                this.totalPhotos = ((Integer) in.readValue((Integer.class.getClassLoader())));
                this.acceptedTos = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            }

            public User_() {
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

            public static class Links___ implements Parcelable {

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
                public final static Parcelable.Creator<Links___> CREATOR = new Creator<Links___>() {


                    @SuppressWarnings({
                            "unchecked"
                    })
                    public Links___ createFromParcel(Parcel in) {
                        return new Links___(in);
                    }

                    public Links___[] newArray(int size) {
                        return (new Links___[size]);
                    }

                };

                protected Links___(Parcel in) {
                    this.self = ((String) in.readValue((String.class.getClassLoader())));
                    this.html = ((String) in.readValue((String.class.getClassLoader())));
                    this.photos = ((String) in.readValue((String.class.getClassLoader())));
                    this.likes = ((String) in.readValue((String.class.getClassLoader())));
                    this.portfolio = ((String) in.readValue((String.class.getClassLoader())));
                    this.following = ((String) in.readValue((String.class.getClassLoader())));
                    this.followers = ((String) in.readValue((String.class.getClassLoader())));
                }

                public Links___() {
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

        public static class Links__ implements Parcelable {

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
            public final static Parcelable.Creator<Links__> CREATOR = new Creator<Links__>() {


                @SuppressWarnings({
                        "unchecked"
                })
                public Links__ createFromParcel(Parcel in) {
                    return new Links__(in);
                }

                public Links__[] newArray(int size) {
                    return (new Links__[size]);
                }

            };

            protected Links__(Parcel in) {
                this.self = ((String) in.readValue((String.class.getClassLoader())));
                this.html = ((String) in.readValue((String.class.getClassLoader())));
                this.download = ((String) in.readValue((String.class.getClassLoader())));
                this.downloadLocation = ((String) in.readValue((String.class.getClassLoader())));
            }

            public Links__() {
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

        public static class Urls implements Parcelable {

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

        public static class ProfileImage_ implements Parcelable {

            @SerializedName("small")
            @Expose
            public String small;
            @SerializedName("medium")
            @Expose
            public String medium;
            @SerializedName("large")
            @Expose
            public String large;
            public final static Parcelable.Creator<ProfileImage_> CREATOR = new Creator<ProfileImage_>() {


                @SuppressWarnings({
                        "unchecked"
                })
                public ProfileImage_ createFromParcel(Parcel in) {
                    return new ProfileImage_(in);
                }

                public ProfileImage_[] newArray(int size) {
                    return (new ProfileImage_[size]);
                }

            };

            protected ProfileImage_(Parcel in) {
                this.small = ((String) in.readValue((String.class.getClassLoader())));
                this.medium = ((String) in.readValue((String.class.getClassLoader())));
                this.large = ((String) in.readValue((String.class.getClassLoader())));
            }

            public ProfileImage_() {
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

    }

    public static class Links implements Parcelable {

        @SerializedName("self")
        @Expose
        public String self;
        @SerializedName("html")
        @Expose
        public String html;
        @SerializedName("photos")
        @Expose
        public String photos;
        @SerializedName("related")
        @Expose
        public String related;
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

        protected Links(Parcel in) {
            this.self = ((String) in.readValue((String.class.getClassLoader())));
            this.html = ((String) in.readValue((String.class.getClassLoader())));
            this.photos = ((String) in.readValue((String.class.getClassLoader())));
            this.related = ((String) in.readValue((String.class.getClassLoader())));
        }

        public Links() {
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(self);
            dest.writeValue(html);
            dest.writeValue(photos);
            dest.writeValue(related);
        }

        public int describeContents() {
            return 0;
        }

    }

    public static class User implements Parcelable {

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
        public Object portfolioUrl;
        @SerializedName("bio")
        @Expose
        public String bio;
        @SerializedName("location")
        @Expose
        public Object location;
        @SerializedName("links")
        @Expose
        public Links_ links;
        @SerializedName("profile_image")
        @Expose
        public ProfileImage profileImage;
        @SerializedName("instagram_username")
        @Expose
        public Object instagramUsername;
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

        protected User(Parcel in) {
            this.id = ((String) in.readValue((String.class.getClassLoader())));
            this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
            this.username = ((String) in.readValue((String.class.getClassLoader())));
            this.name = ((String) in.readValue((String.class.getClassLoader())));
            this.firstName = ((String) in.readValue((String.class.getClassLoader())));
            this.lastName = ((String) in.readValue((String.class.getClassLoader())));
            this.twitterUsername = ((Object) in.readValue((Object.class.getClassLoader())));
            this.portfolioUrl = ((Object) in.readValue((Object.class.getClassLoader())));
            this.bio = ((String) in.readValue((String.class.getClassLoader())));
            this.location = ((Object) in.readValue((Object.class.getClassLoader())));
            this.links = ((Links_) in.readValue((Links_.class.getClassLoader())));
            this.profileImage = ((ProfileImage) in.readValue((ProfileImage.class.getClassLoader())));
            this.instagramUsername = ((Object) in.readValue((Object.class.getClassLoader())));
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

        public static class Links_ implements Parcelable {

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

        public static class ProfileImage implements Parcelable {

            @SerializedName("small")
            @Expose
            public String small;
            @SerializedName("medium")
            @Expose
            public String medium;
            @SerializedName("large")
            @Expose
            public String large;
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


    }

    public static class PreviewPhoto implements Parcelable {

        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("created_at")
        @Expose
        public String createdAt;
        @SerializedName("updated_at")
        @Expose
        public String updatedAt;
        @SerializedName("urls")
        @Expose
        public Urls_ urls;
        public final static Parcelable.Creator<PreviewPhoto> CREATOR = new Creator<PreviewPhoto>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public PreviewPhoto createFromParcel(Parcel in) {
                return new PreviewPhoto(in);
            }

            public PreviewPhoto[] newArray(int size) {
                return (new PreviewPhoto[size]);
            }

        };

        protected PreviewPhoto(Parcel in) {
            this.id = ((String) in.readValue((String.class.getClassLoader())));
            this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
            this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
            this.urls = ((Urls_) in.readValue((Urls_.class.getClassLoader())));
        }

        public PreviewPhoto() {
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(id);
            dest.writeValue(createdAt);
            dest.writeValue(updatedAt);
            dest.writeValue(urls);
        }

        public int describeContents() {
            return 0;
        }

        public static class Urls_ implements Parcelable {

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
            public final static Parcelable.Creator<Urls_> CREATOR = new Creator<Urls_>() {


                @SuppressWarnings({
                        "unchecked"
                })
                public Urls_ createFromParcel(Parcel in) {
                    return new Urls_(in);
                }

                public Urls_[] newArray(int size) {
                    return (new Urls_[size]);
                }

            };

            protected Urls_(Parcel in) {
                this.raw = ((String) in.readValue((String.class.getClassLoader())));
                this.full = ((String) in.readValue((String.class.getClassLoader())));
                this.regular = ((String) in.readValue((String.class.getClassLoader())));
                this.small = ((String) in.readValue((String.class.getClassLoader())));
                this.thumb = ((String) in.readValue((String.class.getClassLoader())));
            }

            public Urls_() {
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

    }

    public static class Tag implements Parcelable {

        @SerializedName("type")
        @Expose
        public String type;
        @SerializedName("title")
        @Expose
        public String title;
        public final static Parcelable.Creator<Tag> CREATOR = new Creator<Tag>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Tag createFromParcel(Parcel in) {
                return new Tag(in);
            }

            public Tag[] newArray(int size) {
                return (new Tag[size]);
            }

        };

        protected Tag(Parcel in) {
            this.type = ((String) in.readValue((String.class.getClassLoader())));
            this.title = ((String) in.readValue((String.class.getClassLoader())));
        }

        public Tag() {
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(type);
            dest.writeValue(title);
        }

        public int describeContents() {
            return 0;
        }

    }

}























