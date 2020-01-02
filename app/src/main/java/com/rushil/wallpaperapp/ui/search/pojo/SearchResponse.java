package com.rushil.wallpaperapp.ui.search.pojo;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;



public class SearchResponse implements Parcelable
{

    @SerializedName("total")
    @Expose
    public Integer total;
    @SerializedName("total_pages")
    @Expose
    public Integer totalPages;
    @SerializedName("results")
    @Expose
    public List<Result> results = null;
    public final static Parcelable.Creator<SearchResponse> CREATOR = new Creator<SearchResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public SearchResponse createFromParcel(Parcel in) {
            return new SearchResponse(in);
        }

        public SearchResponse[] newArray(int size) {
            return (new SearchResponse[size]);
        }

    }
            ;

    protected SearchResponse(Parcel in) {
        this.total = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalPages = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.results, (Result.class.getClassLoader()));
    }

    public SearchResponse() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(total);
        dest.writeValue(totalPages);
        dest.writeList(results);
    }

    public int describeContents() {
        return 0;
    }
    public static class Result implements Parcelable
    {

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
        public Object promotedAt;
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
        public Object description;
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
        @SerializedName("tags")
        @Expose
        public List<Tag> tags = null;
        public final static Parcelable.Creator<Result> CREATOR = new Creator<Result>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Result createFromParcel(Parcel in) {
                return new Result(in);
            }

            public Result[] newArray(int size) {
                return (new Result[size]);
            }

        }
                ;

        protected Result(Parcel in) {
            this.id = ((String) in.readValue((String.class.getClassLoader())));
            this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
            this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
            this.promotedAt = ((Object) in.readValue((Object.class.getClassLoader())));
            this.width = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.height = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.color = ((String) in.readValue((String.class.getClassLoader())));
            this.description = ((Object) in.readValue((Object.class.getClassLoader())));
            this.altDescription = ((String) in.readValue((String.class.getClassLoader())));
            this.urls = ((Urls) in.readValue((Urls.class.getClassLoader())));
            this.links = ((Links) in.readValue((Links.class.getClassLoader())));
            in.readList(this.categories, (java.lang.Object.class.getClassLoader()));
            this.likes = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.likedByUser = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            in.readList(this.currentUserCollections, (java.lang.Object.class.getClassLoader()));
            this.user = ((User) in.readValue((User.class.getClassLoader())));
            in.readList(this.tags, (Tag.class.getClassLoader()));
        }

        public Result() {
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
            dest.writeList(tags);
        }

        public int describeContents() {
            return 0;
        }
        public static class Tag implements Parcelable
        {

            @SerializedName("type")
            @Expose
            public String type;
            @SerializedName("title")
            @Expose
            public String title;
            @SerializedName("source")
            @Expose
            public Source source;
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

            }
                    ;

            protected Tag(Parcel in) {
                this.type = ((String) in.readValue((String.class.getClassLoader())));
                this.title = ((String) in.readValue((String.class.getClassLoader())));
                this.source = ((Source) in.readValue((Source.class.getClassLoader())));
            }

            public Tag() {
            }

            public void writeToParcel(Parcel dest, int flags) {
                dest.writeValue(type);
                dest.writeValue(title);
                dest.writeValue(source);
            }

            public int describeContents() {
                return 0;
            }
            public static class Source implements Parcelable
            {

                @SerializedName("ancestry")
                @Expose
                public Ancestry ancestry;
                @SerializedName("title")
                @Expose
                public String title;
                @SerializedName("subtitle")
                @Expose
                public String subtitle;
                @SerializedName("description")
                @Expose
                public String description;
                @SerializedName("meta_title")
                @Expose
                public String metaTitle;
                @SerializedName("meta_description")
                @Expose
                public String metaDescription;
                @SerializedName("cover_photo")
                @Expose
                public CoverPhoto coverPhoto;
                public final static Parcelable.Creator<Source> CREATOR = new Creator<Source>() {


                    @SuppressWarnings({
                            "unchecked"
                    })
                    public Source createFromParcel(Parcel in) {
                        return new Source(in);
                    }

                    public Source[] newArray(int size) {
                        return (new Source[size]);
                    }

                }
                        ;

                protected Source(Parcel in) {
                    this.ancestry = ((Ancestry) in.readValue((Ancestry.class.getClassLoader())));
                    this.title = ((String) in.readValue((String.class.getClassLoader())));
                    this.subtitle = ((String) in.readValue((String.class.getClassLoader())));
                    this.description = ((String) in.readValue((String.class.getClassLoader())));
                    this.metaTitle = ((String) in.readValue((String.class.getClassLoader())));
                    this.metaDescription = ((String) in.readValue((String.class.getClassLoader())));
                    this.coverPhoto = ((CoverPhoto) in.readValue((CoverPhoto.class.getClassLoader())));
                }

                public Source() {
                }

                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeValue(ancestry);
                    dest.writeValue(title);
                    dest.writeValue(subtitle);
                    dest.writeValue(description);
                    dest.writeValue(metaTitle);
                    dest.writeValue(metaDescription);
                    dest.writeValue(coverPhoto);
                }

                public int describeContents() {
                    return 0;
                }
                public static class CoverPhoto implements Parcelable
                {

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
                    public Object promotedAt;
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
                    public Object description;
                    @SerializedName("alt_description")
                    @Expose
                    public String altDescription;
                    @SerializedName("urls")
                    @Expose
                    public Urls_ urls;
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

                    }
                            ;

                    protected CoverPhoto(Parcel in) {
                        this.id = ((String) in.readValue((String.class.getClassLoader())));
                        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
                        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
                        this.promotedAt = ((Object) in.readValue((Object.class.getClassLoader())));
                        this.width = ((Integer) in.readValue((Integer.class.getClassLoader())));
                        this.height = ((Integer) in.readValue((Integer.class.getClassLoader())));
                        this.color = ((String) in.readValue((String.class.getClassLoader())));
                        this.description = ((Object) in.readValue((Object.class.getClassLoader())));
                        this.altDescription = ((String) in.readValue((String.class.getClassLoader())));
                        this.urls = ((Urls_) in.readValue((Urls_.class.getClassLoader())));
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
                    public static class User_ implements Parcelable
                    {

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
                        public String twitterUsername;
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
                        public Links___ links;
                        @SerializedName("profile_image")
                        @Expose
                        public ProfileImage_ profileImage;
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

                        }
                                ;

                        protected User_(Parcel in) {
                            this.id = ((String) in.readValue((String.class.getClassLoader())));
                            this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
                            this.username = ((String) in.readValue((String.class.getClassLoader())));
                            this.name = ((String) in.readValue((String.class.getClassLoader())));
                            this.firstName = ((String) in.readValue((String.class.getClassLoader())));
                            this.lastName = ((String) in.readValue((String.class.getClassLoader())));
                            this.twitterUsername = ((String) in.readValue((String.class.getClassLoader())));
                            this.portfolioUrl = ((String) in.readValue((String.class.getClassLoader())));
                            this.bio = ((String) in.readValue((String.class.getClassLoader())));
                            this.location = ((String) in.readValue((String.class.getClassLoader())));
                            this.links = ((Links___) in.readValue((Links___.class.getClassLoader())));
                            this.profileImage = ((ProfileImage_) in.readValue((ProfileImage_.class.getClassLoader())));
                            this.instagramUsername = ((String) in.readValue((String.class.getClassLoader())));
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

                        public static class ProfileImage_ implements Parcelable
                        {

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

                            }
                                    ;

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

                        public static class Links___ implements Parcelable
                        {

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

                            }
                                    ;

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
                    public static class Urls_ implements Parcelable
                    {

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

                        }
                                ;

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

                    public static class Links__ implements Parcelable
                    {

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

                        }
                                ;

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
                }

                public static class Ancestry implements Parcelable
                {

                    @SerializedName("type")
                    @Expose
                    public Type type;
                    @SerializedName("category")
                    @Expose
                    public Category category;
                    @SerializedName("subcategory")
                    @Expose
                    public Subcategory subcategory;
                    public final static Parcelable.Creator<Ancestry> CREATOR = new Creator<Ancestry>() {


                        @SuppressWarnings({
                                "unchecked"
                        })
                        public Ancestry createFromParcel(Parcel in) {
                            return new Ancestry(in);
                        }

                        public Ancestry[] newArray(int size) {
                            return (new Ancestry[size]);
                        }

                    }
                            ;

                    protected Ancestry(Parcel in) {
                        this.type = ((Type) in.readValue((Type.class.getClassLoader())));
                        this.category = ((Category) in.readValue((Category.class.getClassLoader())));
                        this.subcategory = ((Subcategory) in.readValue((Subcategory.class.getClassLoader())));
                    }

                    public Ancestry() {
                    }

                    public void writeToParcel(Parcel dest, int flags) {
                        dest.writeValue(type);
                        dest.writeValue(category);
                        dest.writeValue(subcategory);
                    }

                    public int describeContents() {
                        return 0;
                    }
                    public static class Subcategory implements Parcelable
                    {

                        @SerializedName("slug")
                        @Expose
                        public String slug;
                        @SerializedName("pretty_slug")
                        @Expose
                        public String prettySlug;
                        public final static Parcelable.Creator<Subcategory> CREATOR = new Creator<Subcategory>() {


                            @SuppressWarnings({
                                    "unchecked"
                            })
                            public Subcategory createFromParcel(Parcel in) {
                                return new Subcategory(in);
                            }

                            public Subcategory[] newArray(int size) {
                                return (new Subcategory[size]);
                            }

                        }
                                ;

                        protected Subcategory(Parcel in) {
                            this.slug = ((String) in.readValue((String.class.getClassLoader())));
                            this.prettySlug = ((String) in.readValue((String.class.getClassLoader())));
                        }

                        public Subcategory() {
                        }

                        public void writeToParcel(Parcel dest, int flags) {
                            dest.writeValue(slug);
                            dest.writeValue(prettySlug);
                        }

                        public int describeContents() {
                            return 0;
                        }

                    }
                    public static class Type implements Parcelable
                    {

                        @SerializedName("slug")
                        @Expose
                        public String slug;
                        @SerializedName("pretty_slug")
                        @Expose
                        public String prettySlug;
                        public final static Parcelable.Creator<Type> CREATOR = new Creator<Type>() {


                            @SuppressWarnings({
                                    "unchecked"
                            })
                            public Type createFromParcel(Parcel in) {
                                return new Type(in);
                            }

                            public Type[] newArray(int size) {
                                return (new Type[size]);
                            }

                        }
                                ;

                        protected Type(Parcel in) {
                            this.slug = ((String) in.readValue((String.class.getClassLoader())));
                            this.prettySlug = ((String) in.readValue((String.class.getClassLoader())));
                        }

                        public Type() {
                        }

                        public void writeToParcel(Parcel dest, int flags) {
                            dest.writeValue(slug);
                            dest.writeValue(prettySlug);
                        }

                        public int describeContents() {
                            return 0;
                        }

                    }

                    public static class Category implements Parcelable
                    {

                        @SerializedName("slug")
                        @Expose
                        public String slug;
                        @SerializedName("pretty_slug")
                        @Expose
                        public String prettySlug;
                        public final static Parcelable.Creator<Category> CREATOR = new Creator<Category>() {


                            @SuppressWarnings({
                                    "unchecked"
                            })
                            public Category createFromParcel(Parcel in) {
                                return new Category(in);
                            }

                            public Category[] newArray(int size) {
                                return (new Category[size]);
                            }

                        }
                                ;

                        protected Category(Parcel in) {
                            this.slug = ((String) in.readValue((String.class.getClassLoader())));
                            this.prettySlug = ((String) in.readValue((String.class.getClassLoader())));
                        }

                        public Category() {
                        }

                        public void writeToParcel(Parcel dest, int flags) {
                            dest.writeValue(slug);
                            dest.writeValue(prettySlug);
                        }

                        public int describeContents() {
                            return 0;
                        }

                    }
                }
            }

        }

        public static class User implements Parcelable
        {

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
            public String twitterUsername;
            @SerializedName("portfolio_url")
            @Expose
            public String portfolioUrl;
            @SerializedName("bio")
            @Expose
            public Object bio;
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

            }
                    ;

            protected User(Parcel in) {
                this.id = ((String) in.readValue((String.class.getClassLoader())));
                this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
                this.username = ((String) in.readValue((String.class.getClassLoader())));
                this.name = ((String) in.readValue((String.class.getClassLoader())));
                this.firstName = ((String) in.readValue((String.class.getClassLoader())));
                this.lastName = ((String) in.readValue((String.class.getClassLoader())));
                this.twitterUsername = ((String) in.readValue((String.class.getClassLoader())));
                this.portfolioUrl = ((String) in.readValue((String.class.getClassLoader())));
                this.bio = ((Object) in.readValue((Object.class.getClassLoader())));
                this.location = ((Object) in.readValue((Object.class.getClassLoader())));
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
            public static class ProfileImage implements Parcelable
            {

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

                }
                        ;

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
            public static class Links_ implements Parcelable
            {

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

                }
                        ;

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

        public static class Urls implements Parcelable
        {

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

            }
                    ;

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

        public static class Links implements Parcelable
        {

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

            }
                    ;

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
}

























