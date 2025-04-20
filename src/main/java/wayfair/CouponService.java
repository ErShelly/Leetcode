package wayfair;

import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CouponService {
    private final Map<String, String> precomputedCoupons = new HashMap<>();
    private final Map<String, String> categoryToCoupon = new HashMap<>();
    private final Map<String, String> categoryHierarchy = new HashMap<>();

   public CouponService(List<Coupon> coupons, List<Category> categories){
       loadCoupons(coupons);
       loadCategories(categories);
       precomputeBestCoupons(categories);
   }

    private void loadCoupons(List<Coupon> coupons){
        for(Coupon coupon : coupons){
            categoryToCoupon.put(coupon.getCategoryName(), coupon.getCouponName());
        }
    }

    private void loadCategories(List<Category> categories){
        for(Category category:categories){
            categoryHierarchy.put(category.getCategoryName(), category.getParentCategoryName());
        }
    }

    private void precomputeBestCoupons(List<Category> categories) {
        for (Category category : categories) {
            String currCategory = category.getCategoryName();
            String bestCoupon = null;

            while (currCategory != null) {
                if (categoryToCoupon.containsKey(currCategory)) {
                    bestCoupon = categoryToCoupon.get(currCategory);
                    break;
                }
                currCategory = categoryHierarchy.get(currCategory);
            }

            precomputedCoupons.put(category.getCategoryName(), bestCoupon);
        }
    }

    public String findBestCoupon(String category) {
        return precomputedCoupons.getOrDefault(category, null);
    }

    public String getCoupon(String category){
        String currCategory = category;
        while (currCategory != null){
            if(categoryToCoupon.containsKey(currCategory)){
                return categoryToCoupon.get(currCategory);
            }

            currCategory = categoryHierarchy.get(currCategory);
        }

        return null;
    }


    public static void main(String[] args){
        List<Coupon> coupons = Arrays.asList(
                new Coupon("Comforter Sets", "Comforters Sale"),
                new Coupon("Bedding", "Savings on Bedding"),
                new Coupon("Bed & Bath", "Low price for Bed & Bath")
        );

        List<Category> categories = Arrays.asList(
                new Category("Comforter Sets", "Bedding"),
                new Category("Bedding", "Bed & Bath"),
                new Category("Bed & Bath", null),
                new Category("Soap Dispensers", "Bathroom Accessories"),
                new Category("Bathroom Accessories", "Bed & Bath"),
                new Category("Toy Organizers", "Baby And Kids"),
                new Category("Baby And Kids", null)
        );

        CouponService couponService = new CouponService(coupons, categories);

        System.out.println(couponService.findBestCoupon("Comforter Sets")); // Output: Comforters Sale
        System.out.println(couponService.findBestCoupon("Bedding")); // Output: Savings on Bedding
        System.out.println(couponService.findBestCoupon("Bathroom Accessories")); // Output: Low price for Bed & Bath
        System.out.println(couponService.findBestCoupon("Soap Dispensers")); // Output: Low price for Bed & Bath
        System.out.println(couponService.findBestCoupon("Toy Organizers")); // Output: null
    }
}


class Coupon {
    private final String categoryName;
    private final String couponName;

    public Coupon(String categoryName, String couponName){
        this.categoryName = categoryName;
        this.couponName = couponName;
    }

    public String getCategoryName(){
        return this.categoryName;
    }

    public String getCouponName(){
        return this.couponName;
    }
}

class Category {
    private final String categoryName;
    private final String parentCategoryName;

    public Category(String categoryName, String parentCategoryName) {
        this.categoryName = categoryName;
        this.parentCategoryName = parentCategoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getParentCategoryName() {
        return parentCategoryName;
    }
}
