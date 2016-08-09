package com.zhq.gank.mvp.photo.model;

import java.util.List;

/**
 * 作者：hequnsky on 2016/8/4 14:48
 * <p>
 * 邮箱：heuqnsky@gmail.com
 */
public class PhotoModel  {


    /**
     * status : true
     * total : 58
     * tngou : [{"count":166,"fcount":0,"galleryclass":2,"id":841,"img":"/ext/160801/e50cbb3175079e3a211af14e7feb63cf.jpg","rcount":0,"size":17,"time":1470058009000,"title":"腿模林瑞瑜sara粉色可爱女仆裙性感"},{"count":91,"fcount":0,"galleryclass":2,"id":837,"img":"/ext/160801/71eba4c05fd6bc8779c4a4267ad7b831.jpg","rcount":0,"size":10,"time":1470057769000,"title":"马来西亚槟城之花韩小涩 翁依玲图片"},{"count":319,"fcount":0,"galleryclass":2,"id":829,"img":"/ext/160729/d20a5cd187567885234986dd2f4743d9.jpg","rcount":0,"size":9,"time":1469799074000,"title":"Panadol雅蓝色制服高跟美腿"},{"count":305,"fcount":0,"galleryclass":2,"id":800,"img":"/ext/160725/6db46cd2140e27498d518586197a43fd.jpg","rcount":0,"size":8,"time":1469448848000,"title":"韩系气质美女清纯唯美魅惑写真"},{"count":14267,"fcount":0,"galleryclass":2,"id":716,"img":"/ext/160408/b6938f83adf37b1eeb1c320bd5842b88.jpg","rcount":0,"size":23,"time":1460114164000,"title":"清纯女孩松嶋ののか私房诱惑美图"},{"count":8061,"fcount":0,"galleryclass":2,"id":687,"img":"/ext/160310/92093505d160f1a8056ec777cbb8d783.jpg","rcount":0,"size":41,"time":1457573079000,"title":"美女米妮mini大秀巨乳乳沟显清纯 "},{"count":3507,"fcount":0,"galleryclass":2,"id":684,"img":"/ext/160310/93a453490dcda4a4294ace7a8e159fb1.jpg","rcount":0,"size":8,"time":1457572889000,"title":"美女户外清纯靓丽写真"},{"count":3695,"fcount":0,"galleryclass":2,"id":667,"img":"/ext/160301/38c8feeaf15859a543f3a882218c3a14.jpg","rcount":0,"size":28,"time":1456798717000,"title":"日本美女歌手白石麻衣清纯私房照"},{"count":2384,"fcount":0,"galleryclass":2,"id":665,"img":"/ext/160301/1050a224a37030a8e6986cba7b955541.jpg","rcount":0,"size":32,"time":1456798491000,"title":"日本90后美女谷村美月清纯外拍写真图片"},{"count":2930,"fcount":0,"galleryclass":2,"id":651,"img":"/ext/160225/788ea1556d05acc4e0463dd06d53c402.jpg","rcount":0,"size":20,"time":1456359524000,"title":"兔女郎韩雨菲红色制服诱惑写真"}]
     */

    private boolean status;
    private int total;
    /**
     * count : 166
     * fcount : 0
     * galleryclass : 2
     * id : 841
     * img : /ext/160801/e50cbb3175079e3a211af14e7feb63cf.jpg
     * rcount : 0
     * size : 17
     * time : 1470058009000
     * title : 腿模林瑞瑜sara粉色可爱女仆裙性感
     */

    private List<TngouBean> tngou;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<TngouBean> getTngou() {
        return tngou;
    }

    public void setTngou(List<TngouBean> tngou) {
        this.tngou = tngou;
    }

    public static class TngouBean {
        private int count;
        private int fcount;
        private int galleryclass;
        private int id;
        private String img;
        private int rcount;
        private int size;
        private long time;
        private String title;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getFcount() {
            return fcount;
        }

        public void setFcount(int fcount) {
            this.fcount = fcount;
        }

        public int getGalleryclass() {
            return galleryclass;
        }

        public void setGalleryclass(int galleryclass) {
            this.galleryclass = galleryclass;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getRcount() {
            return rcount;
        }

        public void setRcount(int rcount) {
            this.rcount = rcount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
