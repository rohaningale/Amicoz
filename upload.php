<?php

if(isset($_GET['id'])) {
  // u
  $user = $_GET['id'];
} else {
  die("Invalid Username.");
}

function random_string($length) {
    $key = '';
    $keys = array_merge(range(0, 9), range('a', 'z'));
    for ($i = 0; $i < $length; $i++) {
        $key .= $keys[array_rand($keys)];
    }
    return $key;
}

$mysqli = new mysqli('localhost', 'root', 'infa@123', 'db_amicoz');


$file_exts = array("jpg", "bmp", "jpeg", "gif", "png");
$tmp = explode(".", $_FILES["file"]["name"]);
$upload_exts = end($tmp);
if ((($_FILES["file"]["type"] == "image/gif")
  || ($_FILES["file"]["type"] == "image/jpeg")
  || ($_FILES["file"]["type"] == "image/png")
  || ($_FILES["file"]["type"] == "image/pjpeg"))
  && ($_FILES["file"]["size"] < 5000000)
  && in_array($upload_exts, $file_exts))
  {
    if ($_FILES["file"]["error"] > 0)
    {
      echo "Return Code: " . $_FILES["file"]["error"] . "<br>";
    }
    else
    {
      if (file_exists("D:/Workspaces/Step07/src/main/webapp/profilePics/" . $_FILES["file"]["name"])) {
        echo "<div class='error'>"."(".$_FILES["file"]["name"].")".
        " already exists. "."</div>";
      }
      else
      {
        $temp = explode(".", $_FILES["file"]["name"]);
        $newfilename = round(microtime(true)). random_string(50) . '.' . end($temp);
        move_uploaded_file($_FILES["file"]["tmp_name"], "D:/Workspaces/Step07/src/main/webapp/profilePics/" . $newfilename);
        $uid = $user;
		$newfilename = "profilePics/".$newfilename;
        $picture = $mysqli->prepare("UPDATE user_info SET ProfilePic_URL = ? WHERE User_Id = ? LIMIT 1");
        $picture->bind_param('ss', $newfilename, $uid);
        $picture->execute();    // Execute the prepared query.
        $picture->store_result();
        $picture->fetch();
        header("Location: http://localhost:8080/profile_settings");
      }
    }
  }
  else
  {
    //echo "<div class='error'>Invalid file</div>";
	header("Location: http://localhost:8080/profile_settings");
  }
?>
