-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: integrador_fase_1_peliculas
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `pelicula`
--

DROP TABLE IF EXISTS `pelicula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) NOT NULL,
  `url` varchar(255) NOT NULL,
  `genero_id` int NOT NULL,
  `imagen` blob,
  PRIMARY KEY (`codigo`),
  KEY `genero_id` (`genero_id`),
  CONSTRAINT `pelicula_ibfk_1` FOREIGN KEY (`genero_id`) REFERENCES `genero` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula`
--

LOCK TABLES `pelicula` WRITE;
/*!40000 ALTER TABLE `pelicula` DISABLE KEYS */;
INSERT INTO `pelicula` VALUES (1,'tiburon','tiburon.com',1,_binary 'ÿ\Øÿ\à\0JFIF\0\0H\0H\0\0ÿ\Û\0C\0\n\n\n		\n\Z%\Z# , #&\')*)-0-(0%()(ÿ\Û\0C\n\n\n\n(\Z\Z((((((((((((((((((((((((((((((((((((((((((((((((((ÿ\Â\0ˆ\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ú\0\0\0\0•\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\01\Þ\è\à’ŸaóR \0\0\0\0\0\0\0\07Ç£’>C‘<°\Þ\í’\în;‘ÿ\07žŒIVºþ|¨\0\0\0\0\0\0\0‘A”•þ=`~}\èXX—²®‹WD7¿\å \â®.T\0\0\0\0\0\0¦1’x3\Õ\0-s÷@ó\ÙÐ—m]\0¦=ò@³~§§“J\ÝÀ\0\0\0\0\0KÐ¦¨P“ö-od*\0-@üN×­]\0%¨*B‰Iƒtñû\0\0\0\0\0\0\'-h€&d8tpùr ós\ïAÀ\'@Ýµt%u[±ñ¿\æ·qö\0\0\0\0\0\0¿Áü\íG?\Ìö\"\Âs®4Y\ç~†æƒ¦¯bòe5¯ˆX±(c¥\Ñö\0\0\0\0\0\0\0J…<I¹h\\šy\ÆHŒN˜À\ëš\Ùó,ú=\æ7³PT\0\0\0\0\0\0\0\0\0/f$‡ô\Ì\Ö \Þ&Ž~›\ÌÊ•\0\0\0\0\0\0\0\0\0\0|µ3\Û]Û¨ß£ùÜ™¢ÞÃ–¶Nx•\Í\Éóô\0\0\0\0\0\0\0\0–¬y¢ÌŒ\Ìy©™óvœ!Ó£/Ú¼a¹ÿ\0¥¡£r\Ý9ªi6\ç\Ï\Ð\0\0\0\0\0\0\æºÉ®\é?3qw\Ü\nTxù\æt“½fñLN\\kQ\\ñŽ0ûL\r0¥*\0\0\0\0\0\0ba¹ž%\ì¶?\"\0·t_8-z\Í\à*10\ì\Çg³\Í\é\0\0\0\0\0\0)¯\ì4!ùwNÂ’{\ã\ì\Í\Íý#Ì§N^ñ{@.\Æf­(ø·µ\0\0\0\0\0\0\0>\"ùO\Äj{¼%j•,óÿ\0@sñ\Ð7­]`&]™Ï¯°\0\0\0\0\0\0\0\0<P\ä\á`\Öv¸—b7H}€\Éþ\åtö\ÆLòdÀ\0\0\0\0\0\0\0\0\0q\ähbü¦¶L\Z†\ã¶mŠ\Í\à\0\0\0\0\0\0\0\0\0\0¨\Ãó\çEFä¥\Ø~« \0\0\0\0\0\0\0\0\0\0\0|G’.¢m˜ÜŸ\ÑJ€\0\0\0\0\0\0\0\0\0\0LfO\nf«J€\0\0\0\0\0\0\0\0\0\0\0\äI•ú¥@\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0/\0\0\0\0\0\0\0\0@ 1!P$%&2\"#36`pÿ\Ú\0\0ÿ\0\Ç}\Èý\ç\ì6\ç\åò\ëðó\ïlIF(\Òü›\Ög\Õý[.V¯sªnÐƒŠõK¹\Ó\Ð\0Uc\î\Ý¨¢\ÜÞ¡W%[	7ñ¯wõxJE\ê\ê\È6^ˆŸvúš@©ešR´¯#ô:\Ñ}…@\Â\ÕóUIŽ\æN\ßvºO	,#oh€UüoÅ½3\Õtúñh8MC\âh\ç·F\Ö\ì\Ú=\0\']>–¤\rXø_Š\Úk½O¯†¢#yd\Ù>+Ëš¦c{yGRi\Ãe\è\êVj‚L\ßð\ß\én\Ó\ã<\ê,\ßx¿Mi\Ê\å¬ö=Lb;¦—X\ç\Î\Í7øß„µ»O¯ùÔ”ôzi“2`JÅ«°2\Û\ÇÐ£\Êüo\ÄmýKO¯„\Ï:ƒZx}\ÓëŽ£bøhuW÷Y|\Ë|o/ð7\éL‹L\ìS\ë\Æy³§DIÛ¥|òGez\Å\ê\\ð\Ù¸šh¸&\Ã\âO¬\ÈþyO¯	æ¶˜,Î›];—d‡\Ù\Ú| ¡\Â\ÖJ\ç¯ñ8š\ïÁx‹ðk\ë“\Ím! ±\ÓKHˆ\í\Z‹\Ù~\\\Ê\æóS8Oƒ\Ò\æY\ï	\Ðð¿\Û>e2¯gÍ*g€\ÒÃœa1\'„E\é\Ü2¸\Ø©±ˆ\ÖVŸ	§üˆÏ“µý9«¨‚‡\Ûqt€\ÛPMŸ˜Zý\Ë¡‡¨òS¨(P‚Þƒmm{^ed—J\à\0.õP£\Ü\Éö6\çO\çU\âR±\ß<\Õ]\í˜ýe”\Ö{ƒp\äóS@h÷Žñ2ñ«\íiý\ÚY#xC#Yei…ñ\Ä÷S<\ÙÕ¢\Ú\Õp85÷>‰ö\àò«5ýy¥ž\Â\Ò\Ìd·‰¯G©\ÜLósZ\Zª7ªtR(//\è\Úhk\ë0\ã\Ê8úbp>dPø›z\"{ižk\ê‰\çgŸa•—\Z\â\ã\ìf^\Ía\æGó*}r\Ü\ÓË‹\ë\ÌFq5(ðc´™\æþÕ–¾nyõŠ°(x›ô®\\\Çø¥>¼Ùºe¯Z\é¢\\†ñtªúñ\Ù\ìi<Y¨—Y\Ä\Ö\Z¡øl—ñggÇ©\ê|\\Xl„\ÂcC9Á¸¿c¢\ÕSV÷>\îŠ*‰@|wGùró\ç\Òý>O*6€\"›Eb\Ô\á\ìTmŠ\ßUCÑ€üY¬\\J\Çñtù:\È\Õ]zsH¨‡\Ø\ê\çõñ&c•Ÿ‰µiô=O\íé—I¨\æ*\Å>\Êy\ÔY¾õ~›\ÕõDOÀ¿W‰ü«G¤^3Î¨Ð·0²ªˆ£´˜\çR\æEy‡¯G)\ã~(?Ë¹O\æÖm\ìHŽÙ\Ô\á\Ó\Ë6]ñ4\êø#\ÂüJ|·)õ\Éæž€QH‰¯«X\î\r\'\Òcœ`¿Xž_‰\×\Ï~ŸS\Í\'„\Ïgi„\Õ\îoH´lb”Á×‡k3\Å\íXß¬þšú‚@y¨X£¤R½Ý£›\Ù^\\\ÇÜ«0\Ìùhjn\Ñj“-£%‡Ê»\ÛG5\ÔüZ_s‰‹E\îÙ†R\"µ\ïš\0\ïPŽ}\Ý#›÷|uú\ïž™Eøz†¼›\Ö	\ß\Ï?\ëÕ‘\Ã)R»\ß\Ïÿ\0\Ç\ìW(a\ØýŠ\èŽú1ûñ\ÝVC¹±ò{\ïû\×ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0€ÿ\Ú\0?aÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0€ÿ\Ú\0?aÿ\Ä\0>\0\0\0\0\0\0 !\"12AQ@aÁ#Bq±PRSbc‘¡\Ñ0`’¢prs²\áÿ\Ú\0\0?ÿ\0£¾\Íy“?ú}‡k\ï/ñe˜\ÙGóI4Ga»C\Ãx\éW\Ý\ïª.R]ÔµúÄ—+¬|.\ëHÃFVŠ2Huü+Í«\Ú1¤¦p\"ó¤†>\ë\Ù?6£ÙuZ\\S›E|\Úùj©q\Ùm\n¯v…Xðk\Û?§\Åñ\Ç\åý«<z˜q/1\â3É¬ž\ëGŽ¿s\Ézù|¨\0(\Ôƒ\á\ã\\£÷¥Ž!•p\Ð¬\ÌMË§—Ê³.ËŽ%\é\á‹\Ê~KÍ¨\É)´c\å* ²¨°\Z>]\ëh¼R«\Z\Ø;µƒ÷…$±\î<ºxF’VÊ‹¼\Ðƒ¯eASÇ«4s:Hß¯\ë¤c}ÿ\0t4\É Ù¾\Úõ¥t7VÁk¡&ð§?¼k\ÖÛ¸ò¬C£\ß6kt\Òb>ýtû\ÈÇ¿Œjó(a¦>\éŽ\É?	ðL#LÁöXý\ÑM\ß\È8SÖ¥h3{\Ëj\é¦ñ©±iø\r\Üo:\ÜF¯8;&Áþðð$piqmQfºŸºzPq`\ãS¯C¦§õŽŸw¹\Ü·Î¡‰Î§mt¨ƒ*¨°\nX\ä\àe\×P\âÓ‚A«¡\r	#\ßñ/MXf;ÌƒK\ïJ\Ü+VR¾²MMŠû\Ï{w/?U·U\ì¹}Õ¬<©”\ÙM›ó\nBù‡\ÓF\0?\×Go\\‡…:-f’C\Èr¦y‡½\àxK\Ò\Éº°¸¬EÁ\Í1\Ì[¡ò¯1û8 ðµúŽšü–_]¶¹\nu¢ò\Ò9¬je9T˜øYD\\eN_,x…\ÊùŽ®Ì’ja\Â\Ý+=¯\ÕùZ³\Â\ß1\Ìvœ¢\åŽê‡¼|‚\ã²üR·Ô¸©.ùx›¥C&]¼\É!<\é]xX\\x–ŽUÌ¼\Z\á\Ø÷\\›\Ð\Öd\Ô\ã‰:QùTó¯e\Ü\æð§ZiñL\Ý\Ð\Þ}w)\Z÷}:Ñ†eº\ZX\Ñ²@¿ GŠh\äP\È\Û\Åw¸wn\ìð¸\å\åY1$¶\âøMF\Ý\Z\îpú\æ\æ~\íF)˜Fuß›\Ò\Ç…U\Ü<s$ŠNñ]\äZ\à?ñ\ì3\Îs\"ž¦µx÷•Î¥½{÷\Ùß”n\ìm^N‡	\":¹Žž8»¯…z\Öi\Ûä¼…<Ø´Yn£¦ª~€\Ô\ßÞŽôq¼rj\Ø6qÄ<gÞ˜ð­syòyTð¹\ß\â>u–K_-©/¸8\ì\É(\Ö8[˜¥×•†µqÎ²¶\Ì\àk|üVX\ìgmÃ§3±¾ÔB8VÃŸA2‘‘:“ˆ!#ö¤^¤\n·aŽU¸úPx\ÉR­²Õ’K,\ã—_¯jSÂ”\ÓN\ÄG}§\ë\ä)c‰B¢òì“žÉ¤\Ï|\Ù\nký«\â/\×@a°Ë”\Înw^‰K«F\ÛúV»	\Çúøc‡\Ã[¼ø›¥H\í&\î\'jX\ãQw\rXb}t!•B­ÃŒº\Ø|\êpW?zÅ›7,°±\É}‡ô«ðÈ¼K\á.\ÛR7\nõ¦g\'-\î\ïK+•FŽ%ù„5‡¨¿]&ŠUÌA—X\äy8¥–>{\ÇC\àžgÜ¼ºÒ\Ëÿ\0ªÐŠe\ZX•ü—ýµ\Öþ¢ýt\Ú9–\êŠe:Ó˜û\ËI$f\ê\Â\ãÀ˜¦C^\äž\ï~¿ˆt¤–#ua}\'S¸‚*ù\Ç\×M\å”\ÙV¯\'\0\âü«Ò•#\\ªº€ðE‹\án”\Øf\Ê1ýö\Ò5m\ÂAõÒ¹¡hÁ²(\ç\çK·xu±óð™¢ú=\Þc¥& \íŽyùi0¶»\Ò¼¢0Pq¿¾•™\ìgn#\Ó\Ë\Ãl,5¸ZJmˆý\Ú(œŒÞº:¶¦nõ¯o\Æ\íLûJ/?ñ¿‹\ZY¢rÑƒ©\Æõ5\Òe\ã_]­øþº¥:þ\æh\âq:\ãMg§ñ-‚\ê\Â\ÄP\Äa›\Ý\ßQô5a±0Þ‡Ó¶0×´¼§þ\Õ\æ\ÔØœA\É;ý\á@ª<Uˆ½{Wôû\ïÍ•w¯Ê»©µbü»´zökÚ”ð¥{oõ¼\nuÿ\0\åQe€ñ¾Ù‚Ø™5¼ü\èE‰!&ù5HË«Þ“ü\ÖL>Yf#%©1ó¶\ß›}«	ÿ\0ŒxüR\Æ6Woý;³€\îÁòµD²­\Ä\Ï\Ý~ô‹\ã\ä%TL¥JHÈ¾ÝdB9{£æ½¾Àš46gB¢°q•P\éÝ¹›\ÅK\íp>Á\Ö\Êñ\ìÛ¥» \Ä`\Ñ`7ýƒƒ¤ÿ\0a¤mnü©+òû<i-\Þ\"\å·/°\âÂª\è•¶³~a\ÄJb\ÊnüÁÿ\0=ÿ\0ÿ\Ä\0+\0\0\0\0\0\0\0\0\0!1AQa @q‘¡Á\ÑðP±\á`pñÿ\Ú\0\0?!ÿ\0§ò…÷T?\Ñ*üT³€\\\Ýpw6^o \Ñ\ÛKƒ5lÏ´&­Ÿy´\Í\Ë\àý­œ.ùƒ\ê¥Ä–‹’\Âüoƒó-^š79¹´E\Éý\Ï\íƒ•]G^h™Ÿ\Þ\Z@¢\Ô9v\éšû¿¤³;‡Wñ\ÜWé–¢—\Ñ¯ñ\ÜJ²õtA¿ZÄ”%“eˆ\r¢ ñ$\î>\ê«q\Û\Úq<¿\ë_¤t™c\íjpGuŸ]6 \0LÇ“D¹z^ô×”ÀÏ‰˜?ï‰–\î[ŒFi)†_ÙŸ¼`Ù—žü­“tºü±\Ì\ÃU\æ‹ñÁ²y%ûz ePKÓ‹O\éDÒ¯S{¯÷\Ì<š#\ìš\rxñ¿	û@\á—‹\î\ß×“\Z\í¿Vb¦FF\ÙN!\å\Ó@\ËvÏž­KjQ°Fÿ\0›ö\Ä=\0\"#¢G\ÉÀ9?E\ÈA¿2\îo÷¾j‰€øNœ¾\Ò\È)z\Þ:A zj¢\Ç•{²‚\çZ\Ë\â\rù“PRjiO\ÅòÊ¥ý\Ôwöõ=\Õ\ïšÊ¤\rpV+¢®\ZôBešŽF]øk\êðo™§a\rhx—Su\ÂAñÔaý#K\ÅT·ª¼À›.¸\Ý8\è€X\Û×ª\å>Œ`\\÷\Ä\Æ\Zj<½„¯††ˆ‹}¡xK\Æ»üG¨?\Ôt\Ös«­¥G¤¬ª«tÄ¤d¦ðX—n2ÿ\0M\á¶M:a\ëœú¼0n*O\È,x\ÕVk¾vÙ¨µ>ø·¨\íZœVh?ÈµÁ¿‹©òÍºa\ékÁ @\Ö\é‚Eif\×ü÷,÷S¢¦q‡_w5\r\é CoeûžfZi-’™w\íSoPÀd›\Ã¶E=‘NS\ì\×\Ò\æ°ÌªS+“ýF\å9uº„\0¨t‡…©‚\0\é1\ïV\\®;÷ð\Æm\Û[­ž¡\0`\\µ\Ð\Ç;¶&¿Löƒ0?k±~¹™\'1¸ø`ß¬U½|¿\Çs+¥ôI@S½£+{‚Ï”‡F\Ï\ÔŸ¡÷%¦¥“_\È\îYê¨›Pÿ\0\ê\Æ»z#ö!\ß(;M–:eBÎš¡k52°õp‚u€:¿»L\ÜV\Ëû\â|…\×\Ñ,õ\ë\r\íyK\×YL¼@Ã¼\Ýò°^÷~\áUò\'\×ù\ËFÿ\0OR41\á†M\ß$3S½5*°¶$²½5©{½¼†o(PÀ6´\rñ\0\ÈM\Ü\Õ\Ú|l¼P”^G&_b<@ê† !‹\ïôŠý%SL—ð\Î\åiFdª»@6\n\Íð0\Ú}¾)†o\n48ffm¦®ƒÄ³ImÁ\å0©„NE~‰jn\\}÷´	%ñn;‡WF}\ØL™¡{¸?¹Ú¡ôyIÖ û\Ëûù…\ÃS®ðÁô\'\Ýó\\J\ÃÞš\æG*òÀò°Z\Ûô{N“O¢iò¤ú¹²\ä\î]\Õ\ÝIÜ¦\'7^…¿\Ôp\Ò&\ä.­€>%LXùµ\ÊgÄ‰Ì®7{ùYZa~\îÁ2|\ÍM8h\nŽ\è\\ÃŒ¾ÿ\0\ÒWNot·\Ëôµ0ñ\å%@\Õ\Ú|\Ó0WV\ßü@ôB\â\Ü\ß]žb\Û9÷.òjûG7VWwGòò0š„\ÓÉ>8\Ãü\é.„\ä³ðw5\Ôw\ÏÄ³\É62\Ûö-4øª—ª`·ö\êeJ;F\îø•˜ŽÉ«†DÔ­…Ì·ü¢³\Æ×•¢ür¨¿7£«û¼.L\Õ\éÙ\Ï\r\ã½o\ßH\èˆZ5\î,ðT+ð\ÅS*M7§\ÆNW¦|ñ\Äö»\ÃÔ¡u\Æ!À,\Ö9\éµ|ðy;\ê]S\Òj—ø]{x%#‹û@\Û%€õ–\ÄMûlö;š\\ºõø\Ø+(\â.v‚7\ïr\ÇÒ¡\ß9?\r¦\Õ\ë\ÉS?u~b¹2³¤HnÃ™Ì¦\Ø:õ (\r\\\Ç}B\è¼@\\€#;Á4•-Mg\ëo¾}xDB:\nTöN+ªMJr¯û!üQ ô)™¦[ñþ\0´œ\ßÁ”\éIœ‹÷O\àŽŒ¾ƒe¯\åþBo–zþ\ÍU=øTÿ\0ÿ\Ú\0\0\0\0\0\0ó\Ï<ó\Ï<ó\Ï<ó\Ï<ó\Ï<ó\Ï<ó\Ï<ó\Ï<ó\Ï<ó\Ï<ó\Ï<q\Ï<ó\Ï<ó\Ï<ó\Ï8¢\Ì q<ó\Ï<ó\Ï<òB\Ãs\Ï<ó\Ï<ó\ÊS\Åò\Íó\Ï<ó\Ï<Ó<Q\Ï<\Ã\Ï<ó\Ï<ó\Æ<ó\Â4ðLó\Ï<ó\Ï<³03‰\Ó\Ï<ó\Ï<ó\Ï<¢L(!O<ó\Ï<ó\Ï<ó\ÏP\Å<ó\Ï<ó\Ï<ó\Ï<\Ò\Ã\ÃO<ó\Ï<ó\Ï<óN\ã\Å ó\Ï<ó\Ï<ó\Ê0\Ì<±‰<ó\Ï<ó\Ï<s<\ã\Ï8£O<ó\Ï<ó\Î$ó\ÌóI<ó\Ï<ó\Ï<ó\Ë4Ió\Ï<ó\Ï<ó\Ï,2\Ê, \Ï<ó\Ï<ó\Ï<ó\Ï(\ãA<ó\Ï<ó\Ï<ó\Ï<ó\Ï\Ó\Ï<ó\Ï<ó\Ï<ó\Ï<\Ã\Ï<ó\Ï<ó\Ï<ó\Ï<ó\Ê<ó\Ï<ó\Ï<ó\Ï<ó\Ï<!O<ó\Ï<ó\Ï<ó\Ï<ó\Ëó\Ï<ó\Ï<ó\Ï<ó\Ï<ó\Ï<ó\Ï<ó\Ïÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0€ÿ\Ú\0?aÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0€ÿ\Ú\0?aÿ\Ä\0*\0\0\0\0\0\0\0!1AQ@aq± ‘¡PÁ0\Ñð`ñÿ\Ú\0\0?ÿ\0\Ý_ðJ¥w§6¸#W\ç®_‚¥Qüv²\0\æ\æ€\Ü\Ò€´hù‹7!#J8D¦^!þRµ¡tl³QHW+\Ò@\É\ÐkOknB˜\Ù\åA„(±Ê‚¯´Œ$Ç˜!l\É\Ã å¬œ	r\Û÷7R¡±%®mŒ84ƒM\ÐØ£\Îok\ê6F3û¸0cU¯R\'$\ìU9Ü?².€ò\×\Ê\âY\åˆ[\"—¬t9Š\"+~È„!À#‚‰bu.\ÜýIB9\Ç½®×–H\n@DKØ’\Ûql\î\Ñ\æÅ§›[¤y\\0ùGV`‚Ÿh–%–¯erÂ½\ç`ŠŽø\ÓZ¢#‡Š\\=\'§“¤r<0rõ‘ü	|J\È\áþPÀO$µ®ua\í\Ê\è\r²¢h½þU`\Ì\0Aô|§ÌµO÷˜ÇJ•\ë)\í\Âœ$\âôÿ\0\ß\Ñ\\9>ð|ƒÀV€\í–E/öÀx\\ù‘D¥‰D•\Þ4ú1´¸¢~S:S÷ Fe®\ÔòW\æ©YU‡»CüúN¼ 5lS»\0§¨†¦¦l¶¶¬}9HN\åuQ«\r¯«\Ì>†d\Ü÷Y\Éû‡úwý±§ùØ¡0= ÈœŒ@wmvA:¢\êõla>žió?\â:3G·\ÒWX‘\\W†Ç¹\0…²-“yv4À:‚@Y!\èTô¨¸\Â\Z\Ø\Þp¡d£WNû³¦T¿vQ\ê\rG\ÖXhöú[!\Ü?cg­\r£€œ\Ô\0%Y‰R¼•ø\ä¸Ÿ†]-68\Ú\rš\ÊÐ€8Œ\ÕøÉ„–x0\Ù:J–­A\'²3ô¼D[3G\n¾òÆ¸~\× h%\àMS\Ô\0c+\É+®Ò®‚\á´9Q\Âi\é4œ2‘\ËW\n\r´K\çŽ()þŸý\î†gO°²q3}E\ÞwL\à\"‘8NgFb†\r½½l+j´ƒA3\\$N\Öa¼“0\ì\è³,ñ–”•XŠZ\Ã¦Á§û+˜D\å\Ôy°…v *º\Ï\Ãbz\Ô?‚R5-Ë™­oõyKj†ƒ}YŠ]£\Î„°r¤-\Ä}õ\á\0Ÿ§Ê’\à\rJ€™”Àa\é:MŽ\ÆUÿ\09$”*Ó¿U\Ä\n/ÿ\0ƒ=Yÿ\0¤ú,j%®\æ\îô>¦\ÜQ\åz»5¶-\ä%\ÌU¡4Š	0á°‡˜#IAvûO \Ç_^\âÏ©À¡\Ëe‘þ¤b\Z6,÷›É·k“¢U‡“@ÿ\0|®\Ø(‰\àW™’®\Âð\Ä\Æ8\n\î—N¼Tb\äF€(@p@ó¦s	þV=«/kR\Øj²\n\nZ 7\ØH<&ž„¶Žq\îO†Çœ˜ò¬=†öƒ9¦P=\èGn\Ò&QzõùII‡„\Å\r’ú\Ü-<[\á8eJœ¿\ïŸ³\Ím‹ÁÜ¿A3\"\îsöº.\\.¹‚…Þ¦v\Âhr£¨$\Õ\r±‚R*‰\Ìp”\'²y;Q)\Ô\\³\áP9–\ÚÇ˜‘ódö½‘-„4Nö»CB\0”L\Î\ÒÄ“Æ»}²†\É\î\Â\îCQi§tµž\Æ Æ†vej\Ã½8™I>u(ò[‰*aœ°y¸[?ÁC@B~\Þ×•\Ë\01.Š¡›•°z\Ä\ÕþRˆA\"q³\Â\â^Y³$¶ñ n€0`ö¦Gf½Jéƒ·|pò0ÀžP\n±“¤(	rÀ…h£¨¢XÔ€ÿ\0k—\Ö\n<\Ê(Ð¯\ÓJº~\Ï‚\ÈŸ€°«©_‘H\Å!`K jñp²\Åõ–c‰\×5 òU-A”rxh•yh««mAlÝŠ»NW–Px±	 ¬\à>oP;/¼\ÃÂ‰a˜$b\Èðœ\rŒ`\ìª\ÈÝ·–È–òQ…(  #\ÌG\á\È	œ«\Ëeû9-§+(>†m¬¸ð`ƒ\nt\Ô>€HCýF\àB¥€\×{\ÙF\"\îuh\Æ8}!þv;¨¥X†˜Ž5¼?¹TðôŽ\Ð\ÏÔ‹?0\Ü_\ÜRm\î|\Ã\èU\0­ó¿Ì•Á/2k– I:\rA iPº}ó\Õ\É¾c\ä\à1\"f_‹‡«\â,H\Ó\Ð„\â‰{!\ãqu9\n•^§$¢¦µ£õzp<‚Ty!¡\ÍR„<\Ùvp†O0¶\Ô}¥\ZOùJ¥;°Œ<D…k\æ\ÃEƒ\Ö\n«U¬\Ï&\Â,;SË–J«A†À ¨Q¿\ï‚#\à\Î7\Ù_¾	SJ\í\Ì<[(qí‡¤±Í\ÏEÂ€?*\Å8ór„k\×1\â‘I\ZY`\Õ\î \ØN&a\ï­ƒ\ÚP\Íˆ\"\Ø\r\ÓmÙ¸Ô¢\n]gPAˆyad\Îq‡\áõ XwD5q?q’†\ëÜ„\Ì‚fˆ0j¬Bûn\ä(œŽ\ç&2¼\ì&\nó	p¶]‘\Ã£¤\Û\Í;~Z¾Ž\ÐB\'\Ì\Æ\Ø_”ˆ\ß^¤\Ô>¦7\Íb\Ø.˜X$@-\0h^j Kª¼\ê¯	£\Í\êET%O\Ü\ËHk¹æŸ‚1+¤„m»GÈ»L<\åK…71RQ4©ª\Ð2‰J­\\«\rm›\ì-½S\Èl4(\íU$<8\0(\0\Ñ:l¨\Éj\Ñ\È\áwº¯k5ª\Ü%\0€u(-—B„¤AÅ€(¥vûù\æŒÑ…ôŠ+=øCB>1f\Ò\íü61z°t´9	¢:4Lyñw\n³±¢\ÃD¯\àAM[Ž0\Øæ¹?‚DF «°–ŸÀªŒ¢¦Ž\ßðb;?Bñ\Z£n\Â\ì¨hþ”u+ÿ\0/ÿ\Ù');
/*!40000 ALTER TABLE `pelicula` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-20 12:15:03
