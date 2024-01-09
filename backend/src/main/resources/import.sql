INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Alex', 'Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Maria', 'Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_category (name, created_At) VALUES ('Livros', NOW());
INSERT INTO tb_category (name, created_At) VALUES ('Eletrônicos', NOW());
INSERT INTO tb_category (name, created_At) VALUES ('Computadores', NOW());

INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('O Senhor dos Anéis', 90.5, TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z', 'Embarque em uma jornada épica pelos reinos mágicos da Terra Média com "O Senhor dos Anéis". Mergulhe em uma narrativa cativante de heróis, criaturas míticas e uma busca para salvar o mundo das forças das trevas. Esta obra-prima atemporal é indispensável para os entusiastas da fantasia, apresentando uma narrativa rica e construção de mundo incomparável. Liberte sua imaginação e reviva a aventura com esta envolvente obra literária.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('Smart TV', 2190.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Desfrute de entretenimento de alta qualidade com a Smart TV. Com resolução impressionante e tecnologia avançada, esta TV proporciona uma experiência imersiva como nenhuma outra. Navegue por uma variedade de aplicativos e desfrute de conteúdos incríveis na tela grande. Transforme sua sala de estar em um cinema particular com esta Smart TV de última geração.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('Macbook Pro', 1250.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Potência e elegância se unem no Macbook Pro. Este laptop excepcional oferece desempenho rápido e eficiente, perfeito para profissionais e criativos. Com um design fino e leve, leva a produtividade a novos patamares. Experimente a inovação e o estilo incomparáveis do Macbook Pro.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/3-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer', 1200.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Eleve sua experiência de jogo com o PC Gamer. Desempenho incrível e gráficos impressionantes garantem que você esteja sempre à frente na competição. Com um design arrojado e personalizável, este PC atende às demandas dos jogadores mais exigentes. Entre no mundo dos games com o PC Gamer.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/4-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('Rails for Dummies', 100.99, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Explore o universo do desenvolvimento web com "Rails for Dummies". Este guia abrangente é perfeito para iniciantes, proporcionando uma introdução fácil e prática ao mundo do Ruby on Rails. Aprenda a criar aplicações web de forma eficiente e torne-se um desenvolvedor web em pouco tempo.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/5-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Ex', 1350.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Experimente o poder extremo do PC Gamer Ex. Com hardware de última geração, este PC oferece desempenho incomparável para os entusiastas de jogos. Gráficos incríveis e velocidade impressionante garantem uma experiência de jogo imersiva. Domine seus jogos favoritos com o PC Gamer Ex.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/6-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Ex', 1350.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Explore o poder excepcional do PC Gamer Ex. Com hardware de última geração, este PC oferece desempenho superior para entusiastas de jogos. Gráficos incríveis e velocidade impressionante garantem uma experiência de jogo imersiva. Domine seus jogos favoritos com o PC Gamer Ex.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/6-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer X', 1350.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Entre no mundo do gaming com o PC Gamer X. Com uma combinação potente de hardware e design arrojado, este PC oferece desempenho excepcional para jogadores exigentes. Experimente gráficos de alta qualidade e uma jogabilidade suave com o PC Gamer X.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/7-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Alfa', 1850.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Maximize sua experiência de jogo com o PC Gamer Alfa. Projetado para oferecer desempenho máximo, este PC atende às demandas dos jogadores mais dedicados. Desfrute de gráficos impressionantes e uma resposta rápida para uma jogabilidade imersiva.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/8-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Tera', 1950.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Desfrute de uma experiência de jogo imersiva com o PC Gamer Tera. Equipado com hardware de última geração e um design personalizável, este PC oferece desempenho excepcional para satisfazer os jogadores mais ávidos. Experimente gráficos incríveis e uma jogabilidade suave com o PC Gamer Tera.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/9-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Y', 1700.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Entre no mundo do gaming com o PC Gamer Y. Com um equilíbrio perfeito entre desempenho e preço, este PC é ideal para jogadores que buscam uma experiência de jogo excepcional. Desfrute de gráficos impressionantes e jogabilidade suave com o PC Gamer Y.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/10-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Nitro', 1450.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Liberte a energia do Nitro com o PC Gamer Nitro. Projetado para oferecer desempenho sólido a um preço acessível, este PC atende às demandas dos jogadores casuais. Experimente gráficos vibrantes e uma jogabilidade fluida com o PC Gamer Nitro.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/11-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Card', 1850.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Eleve o seu gameplay com o PC Gamer Card. Equipado com hardware avançado e design arrojado, este PC proporciona uma experiência imersiva e de alto desempenho. Desfrute de gráficos incríveis e uma jogabilidade suave com o PC Gamer Card.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/12-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Plus', 1350.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Aprimore sua experiência de jogo com o PC Gamer Plus. Com um equilíbrio perfeito entre desempenho e preço, este PC oferece tudo o que você precisa para mergulhar nos seus jogos favoritos. Desfrute de gráficos impressionantes e desempenho confiável com o PC Gamer Plus.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/13-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Hera', 2250.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Explore novos horizontes com o PC Gamer Hera. Desenvolvido com hardware de ponta e um design elegante, este PC oferece uma experiência de jogo premium. Desfrute de gráficos envolventes e desempenho extraordinário com o PC Gamer Hera.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/14-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Weed', 2200.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Entre no mundo do gaming com estilo com o PC Gamer Weed. Projetado para oferecer um desempenho excepcional e um visual único, este PC é perfeito para os jogadores mais exigentes. Desfrute de gráficos extraordinários e uma experiência de jogo sem igual com o PC Gamer Weed.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/15-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Max', 2340.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Experimente o poder extremo com o PC Gamer Max. Com hardware de última geração, este PC oferece desempenho superior para jogadores que buscam o melhor. Desfrute de gráficos incríveis e jogabilidade sem limites com o PC Gamer Max.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/16-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Turbo', 1280.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Maximize sua experiência de jogo com o PC Gamer Turbo. Projetado para oferecer desempenho excepcional a um preço acessível, este PC é perfeito para jogadores casuais. Desfrute de gráficos impressionantes e uma jogabilidade suave com o PC Gamer Turbo.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/17-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Hot', 1450.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Aqueça seus momentos de jogo com o PC Gamer Hot. Equipado com hardware poderoso, este PC oferece uma experiência envolvente para jogadores apaixonados. Desfrute de gráficos vibrantes e desempenho confiável com o PC Gamer Hot.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/18-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Ez', 1750.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Simplifique sua jornada de jogo com o PC Gamer Ez. Com um equilíbrio perfeito entre desempenho e preço, este PC oferece uma experiência sólida para jogadores de todos os níveis. Desfrute de gráficos incríveis e uma jogabilidade tranquila com o PC Gamer Ez.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/19-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Tr', 1650.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Leve sua experiência de jogo para o próximo nível com o PC Gamer Tr. Equipado com hardware poderoso, este PC oferece desempenho excepcional para jogadores exigentes. Desfrute de gráficos incríveis e uma jogabilidade suave com o PC Gamer Tr.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/20-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Tx', 1680.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Desencadeie a potência com o PC Gamer Tx. Projetado para oferecer um desempenho impressionante, este PC é ideal para jogadores que buscam uma experiência imersiva. Desfrute de gráficos de alta qualidade e velocidade com o PC Gamer Tx.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/21-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Er', 1850.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Eleve seu jogo com o PC Gamer Er. Com um design elegante e hardware avançado, este PC oferece uma experiência de jogo excepcional. Desfrute de gráficos incríveis e desempenho confiável com o PC Gamer Er.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/22-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Min', 2250.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Mergulhe em mundos virtuais com o PC Gamer Min. Equipado com hardware de ponta, este PC proporciona uma experiência de jogo imersiva. Desfrute de gráficos impressionantes e desempenho excepcional com o PC Gamer Min.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/23-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Boo', 2350.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Experimente o poder do PC Gamer Boo. Projetado para jogadores sérios, este PC oferece desempenho excepcional e gráficos de alta qualidade. Mergulhe em seus jogos favoritos com o PC Gamer Boo.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/24-big.jpg');
INSERT INTO tb_product (name, price, date, description, img_url) VALUES ('PC Gamer Foo', 4170.0, TIMESTAMP WITH TIME ZONE '2020-07-14T10:00:00Z', 'Leve sua experiência de jogo a novas alturas com o PC Gamer Foo. Equipado com hardware de última geração, este PC oferece desempenho incomparável e gráficos de tirar o fôlego. Desfrute de jogos de alta qualidade com o PC Gamer Foo.', 'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/25-big.jpg');

INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (3, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (4, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (5, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (6, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (7, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (8, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (9, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (10, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (11, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (12, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (13, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (14, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (15, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (16, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (17, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (18, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (19, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (20, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (21, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (22, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (23, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (24, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (25, 3);