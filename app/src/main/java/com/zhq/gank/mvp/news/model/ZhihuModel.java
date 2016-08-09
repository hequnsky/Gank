package com.zhq.gank.mvp.news.model;

import java.util.List;

/**
 * 作者：hequnsky on 2016/8/4 18:42
 * 邮箱：hequnsky@gmail.com
 */
public class ZhihuModel {

    /**
     * date : 20160628
     * stories : [{"images":["http://pic1.zhimg.com/7d4f8d913d4e7c6d9d28d69ac58bcb68.jpg"],"type":0,"id":8498792,"ga_prefix":"062814","title":"恍然大悟，百科和搜索引擎这样用找资料更高效"},{"images":["http://pic3.zhimg.com/78b679c644e443466faeab51e72c09ba.jpg"],"type":0,"id":8498687,"ga_prefix":"062813","title":"细胞里发现的这条「蛇」，或许跟癌症还有关系"},{"images":["http://pic4.zhimg.com/1da2fec7c46b60d3c9dc2ad1771b5e37.jpg"],"type":0,"id":8498675,"ga_prefix":"062812","title":"大误 · 如果你们能看到，请务必把所有的信息看完"},{"images":["http://pic3.zhimg.com/ee648598625c9ed741985ddd522f519e.jpg"],"type":0,"id":8474066,"ga_prefix":"062811","title":"两个孩子的故事，让人感慨「可怜生在帝王家」"},{"images":["http://pic2.zhimg.com/e56db3b1429611ab26405da9d6133745.jpg"],"type":0,"id":8498068,"ga_prefix":"062810","title":"《小情歌》很难唱好，但还远没有到吴青峰的最高音"},{"images":["http://pic3.zhimg.com/e93715d00404c3651d85f032a6a65e4a.jpg"],"type":0,"id":8480639,"ga_prefix":"062809","title":"同样的钱，你会买奢侈品，还是环球旅行？"},{"images":["http://pic2.zhimg.com/142ea68e84fb50306cf9efabe5e633b5.jpg"],"type":0,"id":8496552,"ga_prefix":"062808","title":"你所在的行业有什么不为人知的趣事？"},{"images":["http://pic2.zhimg.com/f91add0f98c6d5c586d02c1ea88451b1.jpg"],"type":0,"id":8497171,"ga_prefix":"062807","title":"比起「读万卷书」，这个抓小蝴蝶的探险家好像更呆萌"},{"images":["http://pic3.zhimg.com/d8e9e140d86becf88e2971fd33e391be.jpg"],"type":0,"id":8480106,"ga_prefix":"062807","title":"我很有钱，凭什么不能任性地花给我支持的候选人？"},{"images":["http://pic2.zhimg.com/958bc4e8c5679160bcc61918f53034c9.jpg"],"type":0,"id":8496513,"ga_prefix":"062807","title":"上个好大学 · 律师和法官们读书的时候，他们在读什么"},{"images":["http://pic3.zhimg.com/50353110c16a58f5c68121460aaf498a.jpg"],"type":0,"id":8497509,"ga_prefix":"062807","title":"读读日报 24 小时热门 TOP 5 · 人机比赛三个月之后，李世乭谈了谈他的感受"},{"images":["http://pic3.zhimg.com/d3cfd8258d14bdd60fcdd7593a29eac6.jpg"],"type":0,"id":8497153,"ga_prefix":"062806","title":"瞎扯 · 如何正确地吐槽"},{"images":["http://pic1.zhimg.com/de0de27f15374ed1ebed34edd636fbe4.jpg"],"type":0,"id":8494696,"ga_prefix":"062806","title":"这里是广告 · 你听什么情歌，可能与依恋类型有关"}]
     * top_stories : [{"image":"http://pic4.zhimg.com/982d431745b0171dcd6ce2b8bc35dc07.jpg","type":0,"id":8498792,"ga_prefix":"062814","title":"恍然大悟，百科和搜索引擎这样用找资料更高效"},{"image":"http://pic4.zhimg.com/f9060dd2120d8ee9303936c418ca80a3.jpg","type":0,"id":8498068,"ga_prefix":"062810","title":"《小情歌》很难唱好，但还远没有到吴青峰的最高音"},{"image":"http://pic3.zhimg.com/4917f3f63f1eacaa42692b0526032e16.jpg","type":0,"id":8497509,"ga_prefix":"062807","title":"读读日报 24 小时热门 TOP 5 · 人机比赛三个月之后，李世乭谈了谈他的感受"},{"image":"http://pic4.zhimg.com/087e95486c803310ac2683bef67195a3.jpg","type":0,"id":8496513,"ga_prefix":"062807","title":"上个好大学 · 律师和法官们读书的时候，他们在读什么"},{"image":"http://pic3.zhimg.com/1a9a6611835707db6597002a896adeba.jpg","type":0,"id":8496552,"ga_prefix":"062808","title":"你所在的行业有什么不为人知的趣事？"}]
     */

    private String date;
    /**
     * images : ["http://pic1.zhimg.com/7d4f8d913d4e7c6d9d28d69ac58bcb68.jpg"]
     * type : 0
     * id : 8498792
     * ga_prefix : 062814
     * title : 恍然大悟，百科和搜索引擎这样用找资料更高效
     */

    private List<StoriesBean> stories;
    /**
     * image : http://pic4.zhimg.com/982d431745b0171dcd6ce2b8bc35dc07.jpg
     * type : 0
     * id : 8498792
     * ga_prefix : 062814
     * title : 恍然大悟，百科和搜索引擎这样用找资料更高效
     */

    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
