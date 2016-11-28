<?php

$mysqli = new mysqli('localhost:3306', 'root', 'infa@123', 'db_amicoz');


$file_exts = array("jpg", "bmp", "jpeg", "gif", "png");
$upload_exts = end(explode(".", $_FILES["file"]["name"]));
if ((($_FILES["file"]["type"] == "image/gif")
  || ($_FILES["file"]["type"] == "image/jpeg")
  || ($_FILES["file"]["type"] == "image/png")
  || ($_FILES["file"]["type"] == "image/pjpeg"))
  && ($_FILES["file"]["size"] < 2000000)
  && in_array($upload_exts, $file_exts))
  {
    if ($_FILES["file"]["error"] > 0)
    {
      echo "Return Code: " . $_FILES["file"]["error"] . "<br>";
    }
    else
    {
      if (file_exists("../../profilePics/" . $_FILES["file"]["name"])) {
        echo "<div class='error'>"."(".$_FILES["file"]["name"].")".
        " already exists. "."</div>";
      }
      else
      {
        $temp = explode(".", $_FILES["file"]["name"]);
        $newfilename = round(microtime(true)). random_string(50) . '.' . end($temp);
        move_uploaded_file($_FILES["file"]["tmp_name"], "../../profilePics/" . $newfilename);
        $uid = htmlentities($_SESSION['User_Id']);
        $picture = $mysqli->prepare("UPDATE user_info SET ProfilePic_URL = ? WHERE User_Id = ? LIMIT 1");
        $picture->bind_param('ss', $newfilename, $uid);
        $picture->execute();    // Execute the prepared query.
        $picture->store_result();
        $picture->fetch();
        header("Location: /settings/");
      }
    }
  }
  else
  {
    echo "<div class='error'>Invalid file</div>";
  }
?>
