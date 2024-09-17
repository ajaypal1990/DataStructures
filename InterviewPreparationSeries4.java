package com.ajay.concepts;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InterviewPreparationSeries4 {

    public static void main(String[] args) {
        // Create a Map to hold list of blog post categorized by thier type
        Map<BlogPostType, List<BlogPost>> postPerType = new EnumMap<>(BlogPostType.class);


        BlogPost post1 = new BlogPost("News: java 17 released"," Ajay Pal",BlogPostType.NEWS,150);
        BlogPost post2 = new BlogPost("Reviews: Best Practices released"," Anshu Pal",BlogPostType.REVEIW,85);
        BlogPost post3 = new BlogPost("Guide :  Getting Started with Java"," Rashmi Pal",BlogPostType.GUIDE,240);
        BlogPost post4 = new BlogPost("Breaking News: java 19 released"," Jiya Pal",BlogPostType.NEWS,170);
        BlogPost post5 = new BlogPost("Review News: java 12 released"," Ajay Pal",BlogPostType.REVEIW,142);

        postPerType.put(BlogPostType.NEWS, Arrays.asList(post1,post4));
        postPerType.put(BlogPostType.REVEIW, Arrays.asList(post2,post5));
        postPerType.put(BlogPostType.GUIDE, Arrays.asList(post3));

        // Find the Blog post with the maximum likes
        Optional<BlogPost> maxLikes = postPerType.values().stream().flatMap(List::stream)
                .max(Comparator.comparing(blog -> blog.likes));

        maxLikes.ifPresent(blogPost -> {

        });


        // Find the blog post with the maximum likes
        Optional<BlogPost> maxLikesPost = postPerType.values().stream().flatMap(blogpost -> blogpost.stream()).max(Comparator.comparing(post -> post.likes));
        maxLikesPost.ifPresent(blogPost->{
            System.out.println("Blog with maximum likes:");
            System.out.println("Title: " + blogPost.title);
            System.out.println("Author: " + blogPost.author);
            System.out.println("Type: " + blogPost.type);
            System.out.println("Likes: " + blogPost.likes);
        });

        //Group Blog Posts by Author:
        //{"ajay pal": {"post1,post5"}}


        Map<String, List<BlogPost>> postByAuthors = postPerType.values().stream().flatMap(postPer -> postPer.stream())
                .collect(Collectors.groupingBy(blog -> blog.author));


        Map<String,List<BlogPost>> postsByAuthor = postPerType.values().stream().flatMap(List::stream)
                .collect(Collectors.groupingBy(post-> post.author));
        System.out.println();
        postsByAuthor.forEach((author,posts)->{
            System.out.println("Author is: "+author);
            posts.forEach(post-> System.out.println("Title :"+post.title));
        });

        // Give me the Author Name Which have a maximum numbers of posts
        System.out.println("Give me the Author Name Which have a maximum numbers of posts");

        String string = postPerType.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(blogPost -> blogPost.author, Collectors.counting()))
                .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getKey)
                .get();

        System.out.println("Author Which has Maximum numbers of Posts: "+ string);



        //Find the Most Liked Post for Each BlogPostType:

        Map<BlogPostType,BlogPost> mostLikesBlogPost = postPerType.entrySet().stream()
                .collect(Collectors.toMap(entry->entry.getKey(),entry->entry.getValue().stream().max(Comparator.comparing(post->post.likes))
                        .orElseGet(null)));

        Map<BlogPostType,BlogPost> mostLikedPostPerType = postPerType.entrySet()
                .stream().collect(Collectors.toMap(entry->entry.getKey(),entry->entry.getValue().stream()
                        .max(Comparator.comparing(post->post.likes)).orElseGet(null)));
        System.out.println("Most Liked Post for Each BlogPostType");

        mostLikedPostPerType.forEach((key,value)-> System.out.println("Most Liked post in :"+key+":"+ (value != null ? value.title : "None")));



        // Calculate the Total Number of Likes Per Author:
        Map<String,Integer> totalLikesPerAuthor = postPerType.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(blogPost -> blogPost.author,
                        Collectors.collectingAndThen(Collectors.counting(),Long::intValue)));
        totalLikesPerAuthor.forEach((author, likes) -> {
                    System.out.println(author + " has a total of " + likes + " likes.");
                });

        //Count the Number of Blog Posts Per Type:
        Map<BlogPostType,Integer> postCountPerType = postPerType.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(blogPost -> blogPost.type,Collectors.collectingAndThen(Collectors.counting(),Long::intValue)));
        postCountPerType.forEach((type, count) -> {
            System.out.println("There are " + count + " posts in the " + type + " category.");
        });

        //Find the Average Number of Likes Per BlogPostType:
        Map<BlogPostType, Double> averageLikesPerType = postPerType.values().stream().flatMap(List::stream)
                .collect(Collectors.groupingBy(blogPost -> blogPost.type, Collectors.averagingInt(blogpost -> blogpost.likes)));

        System.out.println(averageLikesPerType);


        //Find the Longest Title in Each BlogPostType:
        Map<BlogPostType, String> longestTitlePerType  = postPerType.entrySet().stream().collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue().stream()
                .map(post -> post.title)
                .max(Comparator.comparing(String::length))
                .orElseGet(null)));

        System.out.println(longestTitlePerType);

        //Create a Set of Unique Authors:
        Set<String> uniqueAuthors =postPerType.values().stream().flatMap(List::stream)
                .map(post->post.author)
                .collect(Collectors.toSet());

        System.out.println("Unique Authors: " + uniqueAuthors);

       // Find All Posts Containing a Specific Word:

        String searchWord ="java";
        List<BlogPost>  postsContainingWord = postPerType.values().stream().flatMap(List::stream)
                .filter(word->word.title.toLowerCase().contains(searchWord.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("Posts containing the word '" + searchWord + "':");
        postsContainingWord.forEach(post -> System.out.println("  " + post.title));

        //Create a Map of Blog Titles Grouped by First Letter:
        Map<Character,List<String>> titlesGroupedByFirstLetter = postPerType.values().stream().flatMap(List::stream)
                .map(blogPost -> blogPost.title)
                .collect(Collectors.groupingBy(title->title.charAt(0)));
        titlesGroupedByFirstLetter.forEach((letter, titles) -> {
            System.out.println("Titles starting with '" + letter + "': " + titles);
        });


    }

}


enum BlogPostType{
    NEWS, REVEIW, GUIDE
}

class BlogPost{
    String title;
    String author;
    BlogPostType type;

    int likes;

    public BlogPost(String title, String author, BlogPostType type, int likes) {
        this.title = title;
        this.author = author;
        this.type = type;
        this.likes = likes;
    }
}