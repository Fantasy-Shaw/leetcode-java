package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1912 {
    class MovieRentingSystem {
        // int[3] entry = [shop, movie, price]
        TreeSet<int[]> rent;
        HashMap<Integer, HashMap<Integer, Integer>> shopMoviePrice;
        HashMap<Integer, TreeSet<int[]>> movieEntries;
        Comparator<int[]> cmpEntry = ((a, b) -> {
            if (a[2] != b[2]) {
                return a[2] - b[2];
            } else if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        public MovieRentingSystem(int n, int[][] entries) {
            rent = new TreeSet<>(cmpEntry);
            shopMoviePrice = new HashMap<>(n);
            movieEntries = new HashMap<>();
            for (var entry : entries) {
                int shop = entry[0], movie = entry[1], price = entry[2];
                shopMoviePrice.putIfAbsent(shop, new HashMap<>());
                shopMoviePrice.get(shop).put(movie, price);
                movieEntries.putIfAbsent(movie, new TreeSet<>(cmpEntry));
                movieEntries.get(movie).add(entry);
            }
        }

        public List<Integer> search(int movie) {
            if (!movieEntries.containsKey(movie)) {
                return new ArrayList<>();
            }
            List<Integer> ans = new ArrayList<>();
            for (var entry : movieEntries.get(movie)) {
                ans.add(entry[0]);
                if (ans.size() == 5) {
                    break;
                }
            }
            return ans;
        }

        public void rent(int shop, int movie) {
            int price = shopMoviePrice.get(shop).get(movie);
            int[] entry = new int[]{shop, movie, price};
            rent.add(entry);
            movieEntries.get(movie).remove(entry);
        }

        public void drop(int shop, int movie) {
            int price = shopMoviePrice.get(shop).get(movie);
            int[] entry = new int[]{shop, movie, price};
            rent.remove(entry);
            movieEntries.get(movie).add(entry);
        }

        public List<List<Integer>> report() {
            List<List<Integer>> ans = new ArrayList<>();
            for (var entry : rent) {
                ans.add(List.of(entry[0], entry[1]));
                if (ans.size() == 5) {
                    break;
                }
            }
            return ans;
        }
    }
}