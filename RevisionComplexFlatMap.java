package com.ajay.concepts;

import java.util.*;
import java.util.stream.Collectors;

public class RevisionComplexFlatMap {
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

        Optional<BlogPost> maxBlogPost = postPerType.values().stream().flatMap(List::stream)
                .max(Comparator.comparing(blogPost -> blogPost.likes));

        maxBlogPost.ifPresent(blogPost->{
            System.out.println("Blog with maximum likes:");
            System.out.println("Title: " + blogPost.title);
            System.out.println("Author: " + blogPost.author);
            System.out.println("Type: " + blogPost.type);
            System.out.println("Likes: " + blogPost.likes);
        });
        // Give me the Author Name Which have a maximum numbers of posts

        Map<String, List<BlogPost>> authorPosts = postPerType.values().stream().flatMap(List::stream)
                .collect(Collectors.groupingBy(blogPost -> blogPost.author));

        String authorWithMaxLikes = authorPosts.entrySet().stream().max(Comparator.comparingInt(entry -> entry.getValue().size()))
                .map(Map.Entry::getKey)
                .orElse(null);

        System.out.println(authorWithMaxLikes);

        //Find the Most Liked Post for Each BlogPostType:
        Map<BlogPostType,BlogPost> mostLikesBlogPost = postPerType.entrySet().stream().collect(Collectors.toMap(entry->entry.getKey(),entry->entry.getValue().stream()
                .max(Comparator.comparingInt(blogpost-> blogpost.likes)).orElseGet(null)));

        System.out.println(mostLikesBlogPost);

        // Calculate the Total Number of Likes Per Author:
        Map<String, Integer> totalLikesPerAuthor = postPerType.values().stream().flatMap(List::stream)
                .collect(Collectors.groupingBy(entry -> entry.author, Collectors.summingInt(blogPost-> blogPost.likes)));

        totalLikesPerAuthor.forEach((author, likes) -> {
            System.out.println(author + " has a total of " + likes + " likes.");
        });

        //Count the Number of Blog Posts Per Type:
        Map<BlogPostType,Long> postCountPertype = postPerType.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,entry->(long)entry.getValue().size()));

        System.out.println(postCountPertype);


    }
}
