<?php

$array1 = array(
    'id' => 1,
    'username' => 'Jack & Jhon',
    'review' => 'Kost ini sangat bagus',
    'imgUrl' => 'https://alumni.petra.ac.id/blog/wp-content/uploads/2022/09/21-Jack-_-John-Kitchen.png',
    'tanggal' => '11/02/2023'
);

$array2 = array(
    'id' => 2,
    'username' => 'Makmur sejahtera',
    'review' => 'Kost ini sangat bagus dan apik',
    'imgUrl' => 'https://images.thedirect.com/media/article_full/john-wick-5-movie.jpg',
    'tanggal' => '11/02/2023'
);

$array3 = array(
    'id' => 3,
    'username' => 'Austin',
    'review' => 'Kost ini sangat bagus dan apik dan hebat',
    'imgUrl' => 'https://cdn.pixabay.com/photo/2016/08/08/09/17/avatar-1577909_1280.png',
    'tanggal' => '11/02/2023'
);

$array4 = array(
    'id' => 4,
    'username' => 'Lieandro',
    'review' => 'Kost ini sangattttt bagus',
    'imgUrl' => 'https://t3.ftcdn.net/jpg/02/33/46/24/360_F_233462402_Fx1yke4ng4GA8TJikJZoiATrkncvW6Ib.jpg',
    'tanggal' => '11/02/2023'
);

$array5 = array(
    'id' => 5,
    'username' => 'L*****',
    'review' => 'Sempurna',
    'imgUrl' => 'https://thumbs.dreamstime.com/b/person-gray-photo-placeholder-man-shirt-white-background-person-gray-photo-placeholder-man-132818487.jpg',
    'tanggal' => '11/02/2023'
);

$array6 = array(
    'id' => 6,
    'username' => 'A******',
    'review' => 'Murah dan Bagus',
    'imgUrl' => 'https://i.ytimg.com/vi/6A6c-Xy7qnk/maxresdefault.jpg',
    'tanggal' => '11/02/2023'
);

$array7 = array(
    'id' => 7,
    'username' => 'anonymous',
    'review' => 'ya cukup lah',
    'imgUrl' => 'https://cdn.idntimes.com/content-images/duniaku/post/20230328/untitled-1-148746a5e2378e327d7a929189d7917c.jpg',
    'tanggal' => '11/02/2023'
);

$array8 = array(
    'id' => 8,
    'username' => 'Cukup tau',
    'review' => 'Hebat lah untuk seukuran kost',
    'imgUrl' => 'https://statics.indozone.news/content/2023/03/25/Q8sQvVZ/soal-ending-john-wick-chapter-4-yang-mengejutkan-produser-saya-berharap-dia-gak-mati10_700.jpg',
    'tanggal' => '11/02/2023'
);

if (isset($_GET['id'])) {
    $id = $_GET['id'];

    if ($id == 1) {
        echo json_encode(array($array1, $array2));
    } else if ($id == 2) {
        echo json_encode(array($array3, $array4));
    } else if ($id == 3) {
        echo json_encode(array($array5, $array6));
    } else if ($id == 4) {
        echo json_encode(array($array7, $array8));
    }
}
