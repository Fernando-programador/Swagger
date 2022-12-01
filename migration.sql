CREATE TABLE IF NOT EXISTS `livros` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(250) DEFAULT NULL,
  `paginas` int(11) DEFAULT NULL,
  `titulo` varchar(50) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_g3f1axgwlo51736qi31me3ylx` (`titulo`)
) ;


INSERT INTO `livros` (`id`, `descricao`, `paginas`, `titulo`, `valor`) VALUES
	(1, 'Livro intrigante de suspense base a em fatos reais', 520, 'A vida de John', 150.24),
	(2, 'profissionalizante', 1250, 'engenheiro software', 350.24),
	(3, 'profissionalizante', 550, 'java ', 185),
	(4, 'profissionalizante', 100, 'javaDoc ', 80);

