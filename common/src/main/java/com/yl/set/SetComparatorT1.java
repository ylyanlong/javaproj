package com.yl.set;

import com.yl.entity.VideoAnchor;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Administrator on 2016/3/24.
 */
public class SetComparatorT1 {

    public static void main(String[] args){
        Set<VideoAnchor> set = new TreeSet<VideoAnchor>(new VideoAnchorComparator());
        set.add(new VideoAnchor(1, 21));
        set.add(new VideoAnchor(2, 5));
        set.add(new VideoAnchor(3, 4));
        set.add(new VideoAnchor(4, 8));

        for(VideoAnchor ele: set){
            System.out.println(ele.toString());
        }
    }

}



class VideoAnchorComparator implements Comparator<VideoAnchor>, Serializable{

    @Override
    public int compare(VideoAnchor o1, VideoAnchor o2) {
        long num1 = o1.getNum();
        long num2 = o2.getNum();

        if(num1 < num2){
            return 1;
        } else if (num1 == num2){
            return 0;
        } else {
            return -1;
        }

    }
}



