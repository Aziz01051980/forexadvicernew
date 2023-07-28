-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: articles
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `my_all_articles`
--

DROP TABLE IF EXISTS `my_all_articles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `my_all_articles` (
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `content` varchar(10000) DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_all_articles`
--

LOCK TABLES `my_all_articles` WRITE;
/*!40000 ALTER TABLE `my_all_articles` DISABLE KEYS */;
INSERT INTO `my_all_articles` VALUES ('What sets a professional trader apart from others?','Where and how a professional trader opens a trade?','<p>While millions of people participate in forex trading, only a few achieve success. Success is<br> influenced by factors like theoretical and practical knowledge, as well as risk management. However, <br>one characteristic that distinguishes a professional trader is discipline, according to <br>Trader.org. This quality enables them to adhere to the rules they establish based on their<br> theoretical knowledge and practical experience, leading to consistent success.</p>\n\n<p>A professional trader typically enters trades at the right time and place. They conduct thorough<br> research and make notes on instruments of interest in advance. It\'s no coincidence that<br> Alexander Elder emphasized the importance of record-keeping for good traders. By keeping <br>notes, a trader prepares a scenario for the instrument they\'re interested in and patiently waits<br> for that scenario to unfold. If the instrument moves according to their prediction, the next<br> move is likely to follow the anticipated scenario, prompting the trader to enter the trade at<br> the appropriate moment. However, if the price action deviates from the scenario, the trader <br>refrains from entering the transaction. In such cases, either the calculations were incorrect or<br> the market conditions have changed. In these situations, the best course of action is to <br>exercise patience, as Jesse Livermore, a legendary trader, once advised.</p>\n\n<p>A skilled trader also maintains consistency with their \"stop loss\" and \"take profit\" levels. They<br> establish precise entry and exit points for each specific trade, based on accurate <br>calculations rather than subjective opinions. If the trade progresses as anticipated, it will<br> reach the predetermined point. Conversely, if there is a sudden market change, the trader does not<br> adjust the \"stop loss\" limit. Moving the \"stop loss\" does not alter the market conditions.</p>\n\n<p>Additionally, a professional trader never increases the risk per transaction. Instead, they adhere<br> to consistent rules for entering and exiting each trade. This approach ensures that each <br>trade carries an equal likelihood of resulting in either a profit or a loss. Therefore, there is<br> no logical justification for increasing the risk on one trade over another when both trades <br>possess the same probability of success or failure.</p>\n\n<p>Ultimately, a professional trader possesses both knowledge and experience, but it is their <br>discipline in applying that knowledge and experience that sets them apart.</p>\n\n',3),('Books That Transformed Trading','Influential books that have had a significant impact on the evolution of trading','<p>Books, particularly those of a scientific nature, have played a crucial role in shaping the world\'s<br> development. Just like in other fields, individuals who have achieved remarkable success<br> in trading have documented their wealth of experience in books, sharing their insights<br> with aspiring traders. In this article, presented a selection of influential books that have had a <br>significant impact on the evolution of trading.</p>\n\n<p>Edwin Lefèvre: “Reminiscences of a Stock Operator”</p>\n\n<p>If you truly desire to grasp the essence of trading, this book should be your starting point. It <br>stands unrivaled in its ability to provide a comprehensive understanding of market fluctuations,<br> the mechanisms of market control, and the behaviors of market makers. No other book can offer the<br> same level of insight and comprehension on these subjects.</p>\n\n<p>Ralph Nelson Elliot: \"The Law of Nature: Unlocking the Secrets of the Universe\"</p>\n\n<p>Ralph Elliot, an accomplished accountant during the first half of the 20th century, made a <br>significant mark in the financial arena. Due to health reasons, he transitioned his focus to the<br> stock market and conducted extensive research. During this period, he made a fascinating <br>discovery—an inherent pattern in market movements. According to his findings, market movements<br> consist of five impulse waves and three corrective waves. Waves 1, 3, and 5 represent the primary <br>movement in the same direction, while waves 2 and 4 act as corrections in the opposite direction.<br><br> In a three-wave correction, waves A and C align with the primary movement, while wave B moves<br> in the opposite direction. This groundbreaking revelation was named \"Elliott Waves\" in honor<br> of Ralph Elliot. Subsequent researchers have built upon his work, resulting in a <br>comprehensive body of knowledge encapsulated in the books authored by his successors.</p>\n\n<p>Prechter and Frost: \"A Comprehensive Course in Elliott Wave Principle\"</p>\n\n<p>Robert Prechter\'s life took a transformative turn when he encountered the concept of Elliott Waves.<br> In 1984, he achieved remarkable success by winning first place in the U.S. Trader Championship <br>with a remarkable 450% increase. \"A Comprehensive Course in Elliott Wave Principle\" combines the<br> research of Ralph Elliott and his successors. While Elliott\'s original approach focused <br><br>primarily on the stock market, Prechter\'s book provides a simplified understanding that can also <br>be applied to long-term investing in both forex and the stock market.</p>\n\n<p>Bill Williams: \"Trading Chaos\"</p>\n\n<p>Bill Williams, who struggled with unsuccessful trading for a significant period, stumbled upon the<br> \"Elliott Waves\" theory and subsequently became one of the most successful traders. \"Trading Chaos,\" <br> published in the 1990s, proved to be truly revolutionary during its time. Bill Williams <br>explores both the psychological aspects of trading and its practical application, providing <br>invaluable assistance to numerous traders. This book introduced traders to various approaches and <br>indicators, such as using the MACD indicator to determine the highest point of the third wave,<br> fractals, and the Market Facilitation Index (MFI). Bill Williams\' \"Trading Chaos\" continues to be <br>seminal work in the field of trading.</p>\n\n<p>Larry Williams: \"The Long-Term Secrets of Short-Term Trading\"</p>\n\n<p>This book, written by Larry Williams, stands out for its simplicity. Here you won\'t find the crazy<br> formulas found in other books, but the book is still quite relevant. Larry Williams\' results<br> in the trader\'s championship held in the United States are so high that he is expelled <br>from the competition on charges of fraud. But further investigations confirm that this accusation<br> is groundless. According to Larry Williams, a trader should allow his income to grow.<br> \"When you plant something in your garden, you don\'t take it out every day and look at it. It is <br>necessary to create conditions for the increase of income in trade”.</p>\n\n',4);
/*!40000 ALTER TABLE `my_all_articles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-27 12:18:08
