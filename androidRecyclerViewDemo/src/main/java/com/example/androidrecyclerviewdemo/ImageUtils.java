package com.example.androidrecyclerviewdemo;


public class ImageUtils
{
    public static final String[] IMAGE_URL = new String[]{"http://pic.baike.soso.com/p/20140505/20140505160554-773963972.jpg", "http://p4.gexing.com/touxiang/2012/1/30/201210254969025_200x200_3.jpg",
            "http://imgsrc.baidu.com/forum/w=580/sign=e58d865dd609b3deebbfe460fcbe6cd3/0aefb3de9c82d1587f7c7884870a19d8bd3e426b.jpg", "http://tx.haiqq.com/uploads/allimg/150329/160P143S-5.jpg",
            "http://b.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=aea7b6d337fae6cd0ce1a3653a832312/bd315c6034a85edfb43da9c74b540923dc5475a4.jpg",
            "http://p2.qhimg.com/dr/200_200_/t012b3a8779db7cb1f2.jpg", "http://p4.gexing.com/touxiang/20120804/0842/501c6ff783129_200x200_3.jpg",
            "http://www.sq86.cn/d/file/qqdaima/QQtouxiang/QQgexingtouxiang/2011-09-04/f5f572086b2f4ad875fdbb560ab058cf.jpg", "http://img5.duitang.com/uploads/item/201409/18/20140918205749_uShwa.jpeg",
            "http://p2.qhimg.com/dr/250_500_/t01e7765a834c2eba70.jpg", "http://img3.imgtn.bdimg.com/it/u=188800741,746110388&fm=21&gp=0.jpg",
            "http://imgsrc.baidu.com/forum/w=580/sign=2979942b7ef0f736d8fe4c093a55b382/f2ca14ce36d3d539341dad973c87e950352ab066.jpg",
            "http://e.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=efdbaab39445d688a357baa091f25128/4ec2d5628535e5ddcb37c65f70c6a7efce1b6212.jpg",
            "http://imgsrc.baidu.com/forum/w=580/sign=273803d3aaaf2eddd4f149e1bd110102/e7198694a4c27d1e832a46111dd5ad6edcc438f8.jpg",
            "http://imgsrc.baidu.com/forum/w=580/sign=79dc3c613c292df597c3ac1d8c305ce2/0a261d950a7b020896c6c6af64d9f2d3572cc816.jpg",
            "http://p2.qhimg.com/dr/200_200_/t012b3a8779db7cb1f2.jpg", "http://p4.gexing.com/touxiang/20120804/0842/501c6ff783129_200x200_3.jpg",
            "http://www.sq86.cn/d/file/qqdaima/QQtouxiang/QQgexingtouxiang/2011-09-04/f5f572086b2f4ad875fdbb560ab058cf.jpg", "http://img5.duitang.com/uploads/item/201409/18/20140918205749_uShwa.jpeg",
            "http://p2.qhimg.com/dr/250_500_/t01e7765a834c2eba70.jpg", "http://img3.imgtn.bdimg.com/it/u=188800741,746110388&fm=21&gp=0.jpg",
            "http://imgsrc.baidu.com/forum/w=580/sign=2979942b7ef0f736d8fe4c093a55b382/f2ca14ce36d3d539341dad973c87e950352ab066.jpg",
            "http://e.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=efdbaab39445d688a357baa091f25128/4ec2d5628535e5ddcb37c65f70c6a7efce1b6212.jpg",
            "http://imgsrc.baidu.com/forum/w=580/sign=273803d3aaaf2eddd4f149e1bd110102/e7198694a4c27d1e832a46111dd5ad6edcc438f8.jpg",
            "http://imgsrc.baidu.com/forum/w=580/sign=79dc3c613c292df597c3ac1d8c305ce2/0a261d950a7b020896c6c6af64d9f2d3572cc816.jpg", "http://imgsrc.baidu.com/forum/w=580/sign=273803d3aaaf2eddd4f149e1bd110102/e7198694a4c27d1e832a46111dd5ad6edcc438f8.jpg",
            "http://imgsrc.baidu.com/forum/w=580/sign=79dc3c613c292df597c3ac1d8c305ce2/0a261d950a7b020896c6c6af64d9f2d3572cc816.jpg",
            "http://p2.qhimg.com/dr/200_200_/t012b3a8779db7cb1f2.jpg", "http://p4.gexing.com/touxiang/20120804/0842/501c6ff783129_200x200_3.jpg",
            "http://www.sq86.cn/d/file/qqdaima/QQtouxiang/QQgexingtouxiang/2011-09-04/f5f572086b2f4ad875fdbb560ab058cf.jpg", "http://img5.duitang.com/uploads/item/201409/18/20140918205749_uShwa.jpeg",
            "http://p2.qhimg.com/dr/250_500_/t01e7765a834c2eba70.jpg", "http://img3.imgtn.bdimg.com/it/u=188800741,746110388&fm=21&gp=0.jpg",
            "http://imgsrc.baidu.com/forum/w=580/sign=2979942b7ef0f736d8fe4c093a55b382/f2ca14ce36d3d539341dad973c87e950352ab066.jpg",
            "http://e.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=efdbaab39445d688a357baa091f25128/4ec2d5628535e5ddcb37c65f70c6a7efce1b6212.jpg",
            "http://imgsrc.baidu.com/forum/w=580/sign=273803d3aaaf2eddd4f149e1bd110102/e7198694a4c27d1e832a46111dd5ad6edcc438f8.jpg",
            "http://imgsrc.baidu.com/forum/w=580/sign=79dc3c613c292df597c3ac1d8c305ce2/0a261d950a7b020896c6c6af64d9f2d3572cc816.jpg",
            "http://joymepic.joyme.com/article/uploads/allimg/201508/1440041901750841.jpg",
            "http://imgsrc.baidu.com/forum/w=580/sign=60665890f61f3a295ac8d5c6a924bce3/28286e061d950a7bee3ab78a0cd162d9f2d3c916.jpg",
            "http://imgsrc.baidu.com/forum/w=580/sign=bcea317aaed3fd1f3609a232004f25ce/18459e2f0708283821517e40be99a9014d08f1c4.jpg"

    };
}
