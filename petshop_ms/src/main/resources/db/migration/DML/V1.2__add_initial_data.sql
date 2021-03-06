-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: copipet
-- ------------------------------------------------------
-- Server version	8.0.20
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */
;

/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */
;

/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */
;

/*!50503 SET NAMES utf8mb4 */
;

/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */
;

/*!40103 SET TIME_ZONE='+00:00' */
;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */
;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */
;

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */
;

/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */
;

--
-- Dumping data for table `bonodescuento`
--
/*!LOCK TABLES `bonodescuento` WRITE*/
;

/*!40000 ALTER TABLE `bonodescuento` DISABLE KEYS */
;

/*!40000 ALTER TABLE `bonodescuento` ENABLE KEYS */
;

/*!UNLOCK TABLES*/
;

--
-- Dumping data for table `categoriaproducto`
--
/*!LOCK TABLES `categoriaproducto` WRITE*/
;

/*!40000 ALTER TABLE `categoriaproducto` DISABLE KEYS */
;

INSERT INTO
    `categoriaproducto`
VALUES
    (1, 'alimento'),
    (2, 'accesorios'),
    (3, 'medicamentos'),
    (4, 'productos de aseo');

/*!40000 ALTER TABLE `categoriaproducto` ENABLE KEYS */
;

/*!UNLOCK TABLES*/
;

--
-- Dumping data for table `citapeluqueria`
--
/*!LOCK TABLES `citapeluqueria` WRITE*/
;

/*!40000 ALTER TABLE `citapeluqueria` DISABLE KEYS */
;

/*!40000 ALTER TABLE `citapeluqueria` ENABLE KEYS */
;

/*!UNLOCK TABLES*/
;

--
-- Dumping data for table `citapeluqueria_servicios`
--
/*!LOCK TABLES `citapeluqueria_servicios` WRITE*/
;

/*!40000 ALTER TABLE `citapeluqueria_servicios` DISABLE KEYS */
;

/*!40000 ALTER TABLE `citapeluqueria_servicios` ENABLE KEYS */
;

/*!UNLOCK TABLES*/
;

--
-- Dumping data for table `ciudad`
--
/*!LOCK TABLES `ciudad` WRITE*/
;

/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */
;

INSERT INTO
    `ciudad`
VALUES
    (1, 'Medellín'),
    (2, 'Tunja'),
    (3, 'Barranquilla'),
    (4, 'Manizales'),
    (5, 'Florencia'),
    (6, 'Popayán'),
    (7, 'Yopal'),
    (8, 'Valledupar'),
    (9, 'Montería'),
    (10, 'Bogotá'),
    (11, 'Neiva'),
    (12, 'Santa Marta'),
    (13, 'Villavicencio'),
    (14, 'Mocoa'),
    (15, 'Bucaramanga'),
    (16, 'San Andrés'),
    (17, 'Ibagué'),
    (18, 'Cali'),
    (19, 'Quibdó');

/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */
;

/*!UNLOCK TABLES*/
;

--
-- Dumping data for table `factura`
--
/*!LOCK TABLES `factura` WRITE*/
;

/*!40000 ALTER TABLE `factura` DISABLE KEYS */
;

/*!40000 ALTER TABLE `factura` ENABLE KEYS */
;

/*!UNLOCK TABLES*/
;

--
-- Dumping data for table `factura_citaspeluqueria`
--
/*!LOCK TABLES `factura_citaspeluqueria` WRITE*/
;

/*!40000 ALTER TABLE `factura_citaspeluqueria` DISABLE KEYS */
;

/*!40000 ALTER TABLE `factura_citaspeluqueria` ENABLE KEYS */
;

/*!UNLOCK TABLES*/
;

--
-- Dumping data for table `factura_productos`
--
/*!LOCK TABLES `factura_productos` WRITE*/
;

/*!40000 ALTER TABLE `factura_productos` DISABLE KEYS */
;

/*!40000 ALTER TABLE `factura_productos` ENABLE KEYS */
;

/*!UNLOCK TABLES*/
;

--
-- Dumping data for table `marcaproducto`
--
/*!LOCK TABLES `marcaproducto` WRITE*/
;

/*!40000 ALTER TABLE `marcaproducto` DISABLE KEYS */
;

INSERT INTO
    `marcaproducto`
VALUES
    (1, 'RINGO'),
    (2, 'PEDIGREE'),
    (3, 'HILLS'),
    (4, 'CHUNKI'),
    (5, 'DOG CHOW'),
    (6, 'DOGOURMET'),
    (7, 'MONELLO '),
    (8, 'BRAVECTO'),
    (9, 'ATTACK'),
    (10, 'ADVOCATE'),
    (11, 'GABRICA'),
    (12, 'OUROFINO'),
    (14, 'FIGA S.A'),
    (15, 'GENTAX'),
    (16, 'PETYS'),
    (17, 'CANAMOR'),
    (18, 'CAN AMI'),
    (19, 'DINKY'),
    (20, 'FUMINALS'),
    (21, 'ARGOS'),
    (22, 'DALMATAS'),
    (23, 'INDUPET'),
    (24, 'ANIMAL SHOP'),
    (25, 'XOLO PETS');

/*!40000 ALTER TABLE `marcaproducto` ENABLE KEYS */
;

/*!UNLOCK TABLES*/
;

--
-- Dumping data for table `peluquero`
--
/*!LOCK TABLES `peluquero` WRITE*/
;

/*!40000 ALTER TABLE `peluquero` DISABLE KEYS */
;

INSERT INTO
    `peluquero`
VALUES
    (1, 'Xiomara Hernandez Ortiz'),
    (2, 'Vlentina Hernandez Ortiz');

/*!40000 ALTER TABLE `peluquero` ENABLE KEYS */
;

/*!UNLOCK TABLES*/
;

--
-- Dumping data for table `producto`
--
/*!LOCK TABLES `producto` WRITE*/
;

/*!40000 ALTER TABLE `producto` DISABLE KEYS */
;

INSERT INTO
    `producto`
VALUES
    (
        1,
        'Ringo Vitality Super Premium Cachorros',
        20090,
        '2 kg',
        '0',
        'Ringo vitality super premium cachorros, Es un alimento que incrementa las defensas de tu mascota, disminuyendo el riesgo de enfermedades.',
        'Ringo Vitality Cachorros aporta proteínas provenientes de varias fuentes de origen animal como cordero, pavo, pollo, huevo deshidratado y leche en polvo deslactosada. Este alimento respeta la naturaleza de tu mascota proporcionando los nutrientes, minerales y vitaminas esenciales para su crecimiento y bienestar. Está formulado con arveja y almidones de papa y yuca aportando energía a tu cachorro. Proteína mínimo 28%, grasa mínimo 15%, fibra máximo 4%, cenizas máximo 8%, humedad máximo 10%',
        'Aporta proteínas de origen animal y respeta la naturaleza de tu perro proporcionando los nutrientes, minerales y vitaminas esenciales que contribuyen al bienestar y vitalidad del cachorro por largo tiempo. Ayuda a reforzar el sistema de defensas, vitaminas y minerales esenciales, con proteína animal',
        'RVSPC2',
        1,
        1
    ),
    (
        2,
        'Ringo Vitality Super Premium Cachorros',
        78790,
        '8 kg',
        '0',
        'Ringo vitality super premium cachorros, Es un alimento que incrementa las defensas de tu mascota, disminuyendo el riesgo de enfermedades.',
        'Ringo Vitality Cachorros aporta proteínas provenientes de varias fuentes de origen animal como cordero, pavo, pollo, huevo deshidratado y leche en polvo deslactosada. Este alimento respeta la naturaleza de tu mascota proporcionando los nutrientes, minerales y vitaminas esenciales para su crecimiento y bienestar. Está formulado con arveja y almidones de papa y yuca aportando energía a tu cachorro. Proteína mínimo 28%, grasa mínimo 15%, fibra máximo 4%, cenizas máximo 8%, humedad máximo 10%',
        'Aporta proteínas de origen animal y respeta la naturaleza de tu perro proporcionando los nutrientes, minerales y vitaminas esenciales que contribuyen al bienestar y vitalidad del cachorro por largo tiempo. Ayuda a reforzar el sistema de defensas, vitaminas y minerales esenciales, con proteína animal',
        'RVSPC8',
        1,
        1
    ),
    (
        3,
        'Pedigree Alimento Para Perro Adulto',
        20990,
        '2 kg',
        '0',
        'Pedigree alimento para perro adulto, Contiene múltiples beneficios como la proteína de alta calidad, fibras naturales, minerales, vitaminas y omega 6 que proporciona más energía.',
        'El Arroz, Los Cereales Integrales Y La Fibra Prebiótica Natural Mantienen Su Sistema Digestivo Sano, Para Que Esté Feliz Y Cómodo Y Sus Deposiciones Sean Fáciles De Recoger. Las Proteínas De Carne De Alta Calidad Ayudan A Darle La Energía Que Necesita Para Jugar A Cobrar Su Pelota Favorita. La Vitamina E, Un Antioxidante Natural, Ayuda A Proteger Su Sistema Inmunitario, Y No Tendrás Que Preocuparte Por Qué Olisquea Cuando No Le Estás Mirando. Hasta El Último Trocito De Nuestro Raza Pequeña Complete Está Bañado En Suculentos Jugos, Y Sabes Que Acudirá Corriendo Nada Más Oír La Bolsa. Las Croquetas Pequeñas Especialmente Diseñadas Le Ayudan A Mantener Sus Dientes En Perfecto Estado Para Jugar Con Su Mordedor De Cuerda Favorito. Además, No Contienen Azúcares Añadidos, Un Alimento Desarrollado Con Todos Los Estandares De Calidad Necesarios Para Tu Mascota',
        'Mejorar las articulaciones, el aspecto del pelo y mejora la fortaleza de las uñas. Su fórmula esta diseñada para dar una nutrición completa gracias a sus niveles de proteínas buenas.',
        'PAPPA2',
        1,
        2
    ),
    (
        4,
        'Pedigree Alimento Para Perro Adulto',
        124990,
        '15 kg',
        '0',
        'Pedigree alimento para perro adulto, Contiene múltiples beneficios como la proteína de alta calidad, fibras naturales, minerales, vitaminas y omega 6 que proporciona más energía.',
        'El Arroz, Los Cereales Integrales Y La Fibra Prebiótica Natural Mantienen Su Sistema Digestivo Sano, Para Que Esté Feliz Y Cómodo Y Sus Deposiciones Sean Fáciles De Recoger. Las Proteínas De Carne De Alta Calidad Ayudan A Darle La Energía Que Necesita Para Jugar A Cobrar Su Pelota Favorita. La Vitamina E, Un Antioxidante Natural, Ayuda A Proteger Su Sistema Inmunitario, Y No Tendrás Que Preocuparte Por Qué Olisquea Cuando No Le Estás Mirando. Hasta El Último Trocito De Nuestro Raza Pequeña Complete Está Bañado En Suculentos Jugos, Y Sabes Que Acudirá Corriendo Nada Más Oír La Bolsa. Las Croquetas Pequeñas Especialmente Diseñadas Le Ayudan A Mantener Sus Dientes En Perfecto Estado Para Jugar Con Su Mordedor De Cuerda Favorito. Además, No Contienen Azúcares Añadidos, Un Alimento Desarrollado Con Todos Los Estandares De Calidad Necesarios Para Tu Mascota',
        'Mejorar las articulaciones, el aspecto del pelo y mejora la fortaleza de las uñas. Su fórmula esta diseñada para dar una nutrición completa gracias a sus niveles de proteínas buenas.',
        'PAPPA15',
        1,
        2
    ),
    (
        5,
        'Hills Science Diet Adult Small Paws Chicken Dog',
        63100,
        '4.5 Lb',
        '0',
        'Hills science diet adult small paws chicken dog, Grande en amor, pequeño en tamaño. el alimento seco para perros es nutrición diseñada para las necesidades únicas de los perros pequeños y miniatura durante los mejores años de su vida. hecho especialmente en bocados pequeñitos.',
        'Ingredientes: Harina de pollo, arroz cervecero, trigo integral, harina de soja, sorgo integral, grasa de pollo, cebada perlada molida, maíz integral, sabor a hígado de pollo, sabor a hígado de cerdo, linaza, ácido láctico, aceite de soja, guisantes, manzanas , vitaminas (suplemento de vitamina E, L-ascorbil-2-polifosfato (fuente de vitamina C), suplemento de niacina, mononitrato de tiamina, suplemento de vitamina A, pantotenato de calcio, suplemento de riboflavina, biotina, suplemento de vitamina B12, clorhidrato de piridoxina, ácido fólico, vitamina Suplemento D3), arándanos, cloruro de potasio, L-lisina, sal yodada, zanahorias, cloruro de colina, brócoli, taurina, minerales (sulfato ferroso, óxido de zinc, sulfato de cobre, óxido manganoso, yodato de calcio, selenito de sodio), tocoferoles mixtos para frescura , Sabores naturales, L-Carnitina, Betacaroteno. Proteína 18.4%, Grasa 15,5%, Fibra Cruda 1,8%, Carbohidratos 57,3%, Calcio 0.8%, Fosforo 0.58%, Sodio 0.37%, Potasio 1.17%.',
        'Ingredientes fáciles de digerir para una digestión sana, mezcla nutritiva de omega-6 y vitamina E para una piel sana y un pelaje lujoso, proteína de alta calidad para músculos magros, contiene nuestra mezcla antioxidante especial Small & Mini para apoyo inmunológico de por vida.',
        'HSDAS1',
        1,
        3
    ),
    (
        6,
        'Hills Prescription Diet D/D Skin/ Food Sensitivities Dog',
        171800,
        '8 Lb',
        '0',
        'Hills prescription diet d/d skin/ food sensitivities dog, Formula única con proteína novedosa (huevo) y única fuente de carbohidratos (arroz). también beneficia a perros con enfermedades cutáneas no alérgicas, al proporcionarles nutrientes esenciales.',
        'Salmón y Patatas,Patatas, almidón de patata, salmón, proteína de patata, grasa de cerdo, aceite de soja, sabor de cerdo, fosfato dicálcico, ácido láctico, aceite de pescado, harina de pescado, cloruro de potasio, celulosa en polvo, sal yodada, carbonato de calcio, cloruro de colina, vitaminas Suplemento de vitamina A, suplemento de vitamina A, suplemento de vitamina A, suplemento de vitamina A, suplemento de vitamina B12, clorhidrato de piridoxina, suplemento de riboflavina, biotina, ácido fólico, suplemento de vitamina D3), DL Metionina, Taurina, minerales (sulfato ferroso, óxido de zinc, sulfato de cobre, óxido de manganeso, yodato de calcio, selenita sódica), L-triptófano, tocoferoles mixtos para la frescura, sabores naturales, betacaroteno. Proteína 18.4%, Grasa 15,5%, Fibra Cruda 1,8%, Carbohidratos 57,3%, Calcio 0.8%, Fosforo 0.58%, Sodio 0.37%, Potasio 1.17%.',
        'Alto en ácidos grasos Omegas 3 y 6. Con formula antioxidante superior Tiene una proteína novedosa (salmon) /Ayuda a mantener una barrera cutánea saludable.',
        'HPDDS8',
        1,
        3
    ),
    (
        7,
        'Chunky Cordero, Arroz Y Salmón Adulto',
        21200,
        '1.5 kg',
        '0',
        'Chunky cordero, arroz y salmón adulto, El concentrado para perros adultos chunky con sabor a cordero, arroz y salmón es un concentrado fabricado con carne de verdad y apto para perros adultos de todas las razas. además, cuenta con ingredientes no alérgicos ideal para aquellos perros con estómagos y pieles sensibles, como el cordero y el salmón que eliminan la posibilidad de irritación y reacciones alérgicas que se pueden presentar en algunos perros frente a otros ingredientes comunes presentes en concentrados regulares.',
        'Arroz, salmón, cordero, harina de salmón, salvado de trigo, aceite de pollo, hidrolizado de hígado de pollo, semilla de lino, cloruro de sodio, carbonato de calcio, fosfato dicálcico, cloruro de potasio, manano -oligosacáridos de la (no-GM) saccharomyces cerevisiae, cloruro de colina, hierro quelado, sulfato ferroso, hidroxicloruro de zinc, zinc quelado, beta-glucanos, selenio quelado, cobre básico cloruro, cobre quelado, yodato de calcio, hidroxicloruro de manganeso, manganeso quelado, selenito de sodio, vitamina E tocoferol acetato, vitamina B3 niacinamida, vitamina B5, vitamina A retinol, vitamina H biotina, vitamina B2 riboflavina, vitamina K3 menadiona, vitamina B12 cianocobalamina, vitamina B1 tiamina, vitamina B6 piridoxina, vitamina D3 colecalciferol, vitamina B9 ácido fólico, sales de ácido propiónico, tocoferoles, aceite de romero, ácido cítrico.{ Chunky perros esta diseñado para soportar su salud y bienestar, es un alimento elaborado con altos estándares de calidad, diseñado para favorecer y cubrir los requerimientos nutricionales y energia que necesitan a diario. Análisis Garantizado: Proteína Mínimo 21,0% - Calcio Mínimo 1,0% - Fósforo Mínimo 0,8% - Grasa Mínimo 10,0% - Fibra Máximo 4,0% - Ceniza Máximo 8,0% - Humedad Máximo 10,0%',
        'Chunky perros esta diseñado para soportar su salud y bienestar, es un alimento elaborado con altos estándares de calidad, diseñado para favorecer y cubrir los requerimientos nutricionales y energia que necesitan a diario.',
        'CCASA1',
        1,
        4
    ),
    (
        8,
        'Chunky Cordero, Arroz Y Salmón Adulto',
        51700,
        '4 kg',
        '0',
        'Chunky cordero, arroz y salmón adulto, El concentrado para perros adultos chunky con sabor a cordero, arroz y salmón es un concentrado fabricado con carne de verdad y apto para perros adultos de todas las razas. además, cuenta con ingredientes no alérgicos ideal para aquellos perros con estómagos y pieles sensibles, como el cordero y el salmón que eliminan la posibilidad de irritación y reacciones alérgicas que se pueden presentar en algunos perros frente a otros ingredientes comunes presentes en concentrados regulares.',
        'Arroz, salmón, cordero, harina de salmón, salvado de trigo, aceite de pollo, hidrolizado de hígado de pollo, semilla de lino, cloruro de sodio, carbonato de calcio, fosfato dicálcico, cloruro de potasio, manano -oligosacáridos de la (no-GM) saccharomyces cerevisiae, cloruro de colina, hierro quelado, sulfato ferroso, hidroxicloruro de zinc, zinc quelado, beta-glucanos, selenio quelado, cobre básico cloruro, cobre quelado, yodato de calcio, hidroxicloruro de manganeso, manganeso quelado, selenito de sodio, vitamina E tocoferol acetato, vitamina B3 niacinamida, vitamina B5, vitamina A retinol, vitamina H biotina, vitamina B2 riboflavina, vitamina K3 menadiona, vitamina B12 cianocobalamina, vitamina B1 tiamina, vitamina B6 piridoxina, vitamina D3 colecalciferol, vitamina B9 ácido fólico, sales de ácido propiónico, tocoferoles, aceite de romero, ácido cítrico.{ Chunky perros esta diseñado para soportar su salud y bienestar, es un alimento elaborado con altos estándares de calidad, diseñado para favorecer y cubrir los requerimientos nutricionales y energia que necesitan a diario. Análisis Garantizado: Proteína Mínimo 21,0% - Calcio Mínimo 1,0% - Fósforo Mínimo 0,8% - Grasa Mínimo 10,0% - Fibra Máximo 4,0% - Ceniza Máximo 8,0% - Humedad Máximo 10,0%',
        'Chunky perros esta diseñado para soportar su salud y bienestar, es un alimento elaborado con altos estándares de calidad, diseñado para favorecer y cubrir los requerimientos nutricionales y energia que necesitan a diario.',
        'CCASA4',
        1,
        4
    ),
    (
        9,
        'Dog Chow Salud Visible Cachorros Minis Y Pequeños',
        160420,
        '17 kg',
        '0',
        'Dog chow salud visible cachorros minis y pequeños, Equilibra la flora intestinal. probiótico natural, desarrollo del cerebro y la visión. dha derivado del pescado, promueve un pelaje brillante. omegas 6 y 3, crecimiento sano.',
        'Maíz y/o sorgo, harina proteica de pollo, harina de carne y hueso, harina de pescado y/o harina de alga, arroz, concentrado proteico de maíz, harina de soya y/o concentrado proteico de soya, trigo, grasa animal y/o aceite vegetal estabilizado con antioxidantes (BHT), saborizante a base de menudencias de cerdo y/o pollo, inulina, sal, fosfato de calcio, arveja deshidratada, zanahoria deshidratada, taurina, L-lisina, DL-Metionina, cloruro de colina, carbonato de calcio, cloruro de potasio, colores artificiales (rojo # 40, amarillo # 5, amarillo #6, azul # 2), niacina, suplementos vitamínicos (A, E, B12, D3), pantotenato de calcio, suplemento de riboflavina, biotina, ácido fólico, mononitrato de tiamina, clorhidrato de piridoxina, complejo menadiona sódica bisulfito (fuente de actividad de vitamina K), sulfato de zinc, proteinato de zinc, sulfato ferroso, proteinato de hierro, sulfato de manganeso, proteinato de manganeso, sulfato de cobre, proteinato de cobre, yodato de calcio, selenito de sodio, proteinato de selenio. energía metabolizable (calculada): 3.800 kcal/kg Análisis Garantizado: Proteína Cruda (mín.) 23,0%, Grasa Cruda (mín-máx.) 4,0% - 8,0%, Fibra Cruda (máx.) 9,0%, Humedad (máx.) 12,0%, Cenizas (máx.) 9,0%, Calcio (mín-máx.) 1,0% - 1,6% , Fósforo (mín./máx.) 0,9%-1,3%.',
        'Nutrición específicamente diseñada para el óptimo desarrollo de tu cachorrito mini o pequeño que ayuda a mejorar su calidad de vida desde adentro hacia afuera de forma visible.',
        'DCSVC17',
        1,
        5
    ),
    (
        10,
        'Dogourmet Carne A La Parrilla Adulto',
        9052,
        '1.2 kg',
        '0',
        'Dogourmet carne a la parrilla adulto, Con un irresistible sabor a carne a la parrilla que deleitará los paladares de los consentidos de la casa, el sistema knutro ha sido ciudadosamente diseñado e incorporado a la fórmula.',
        'Cereales y subproductos de cereales (maiz, arroz y/o trigo), harinas de carne y/o harina de pescado, harina de soya, concentrados proteicos de origen vegetal hidrolizado de proteina animal, levadura de cerveza, subproductos de cerveceria, premezcla vitaminica (A, D, E, B1, B2, B6, B12, niacina, ácido pantoténico, ácido fólico, biotina y cloruro de colina) premezcla mineral (hierro, cobre, zinc, selenio, yodo, manganeso), sal, espinacas deshidratadas, zanahorias deshidratadas, antioxidantes. Dogourmet carne adulto. Aliento seco para perros adultos. Caracteristicas: Proteína Cruda (Mín.) 21.0% Grasa Cruda (Mín.) 6.0% Fibra Cruda (Máx.) 4.0% Humedad (Máx.) 12.0% Calcio (Mín) 2.0% Fósforo (Min)',
        'Dogourmet con una combinación de ingredientes ricos en proteínas, carbohidratos, vitaminas y minerales, que garantizan la salud y el bienestar de tu perro.',
        'DCAPA1',
        1,
        6
    ),
    (
        11,
        'Monello Raza Pequeña',
        11880,
        '1 kg',
        '0',
        'Monello raza pequeña, Alimento premium ideal para perros pequeños adultos, al contener altos niveles de proteínas altamente seleccionadas, proporciona minerales y vitaminas que ayudarán el crecimiento sano de tu mascota. contiene linaza la cual junto con el aceite de oliva permiten que tu mascota tenga una mejor digestión y absorción del alimento.',
        'El alimento posee ingredientes seleccionados, como proteínas de origen animal y vegetal, vitaminas y minerales, contiene semilla de linaza, aceite de oliva, que auxilia en la belleza del pelo y de la piel, y Mananoligosacaridos (MOS), que proporcionan una mejor digestión y absorción por el organismo de su perro.Contiene: Vitaminas, minerales, proteína de original vegetal y animal. Plus: Mejora la digestión de la mascota al contener linaza. omegas: 3 y 6. Ingredientes: Proteína 33%, grasa 21%, ácidos grasos 4%, ceniza bruta 6.5%, fibras brutas 1,9%, calcio 1,3%, fósforo 1,18% y DHA al 0, 18%.',
        'Si tu perro tiene una buena alimentación disminuirá su riesgo de presentar enfermedades. Contiene Yucca Schidigera, que, a través de la saponina, reduce el volumen de la materia fecal, facilitando la limpieza y contribuyendo para un ambiente más higiénico. Además posee nuggets rellenos, para una comida con mucho más sabor.',
        'MMRPP1',
        1,
        7
    ),
    (
        14,
        'Advocate Pipeta Gatos Grandes Hasta 8 Kg',
        41300,
        '0.8 mililitro',
        '0',
        'Advocate pipeta gatos grandes hasta 8 kg, Es un antipulgas para perros pequeños que elimina y previene la existencia de pulgas adultas y larvas presentes en tu mascota. tipo parásito garrapata, tipo mascota gato, tamaño mascota todos, etapa de vida adulto, tipo producto antipulgas solución tópica para uso externo únicamente. separe el pelo de la parte posterior de la cabeza del perro y aplique todo el contenido de la pipeta directamente sobre la piel del animal, una sola pipeta de aventaje.',
        'Endectoparasitario, larvas y pulgas, administrar desde las 9 semanas de vida y hasta los 8 kg de peso, composición imidacloprid 10 mg/ml, moxidectina 10 mg/ml, tratamiento de 4 semanas.',
        'Por tanto, el uso del medicamento debe basarse en la valoración de cada caso individual y en factores epidemiológicos locales sobre la sensibilidad de los parásitos para disminuir el riesgo de la selección de resistencias en el futuro. El uso del medicamento debe basarse en la confirmación mediante diagnóstico de la existencia de infecciones mixtas.',
        'APGG8',
        3,
        10
    ),
    (
        15,
        'Bravecto Perros De 40 Hasta 56 Kg',
        116200,
        '1400 mg',
        '0',
        'Bravecto perros de 40 hasta 56 kg, Comprimidos masticables para el control de pulgas, ácaros y garrapatas en perros.',
        'Protección simultanea contra pulgas y garrapatas por 12 semanas. Para el tratamiento de infestaciones por ácaros. Se puede utilizar durante la reproducción, gestación o lactancia. Bravecto mata las pulgas adultas y está indicado para el tratamiento y la prevención de infestaciones por pulgas (Ctenocephalides felis y C Canis) y para el tratamiento y el control de infestaciones por garrapatas (Rhipicephalus sanguineus) durante 12 semanas en perros y cachorros a partir de los 2 meses de edad, que pesen 2 kilogramos o más. Previene la trasmisión de Babesia canis como minimo por 12 semanas. Tratamiento de demodicosis (Demodex spp) y de Sarna Sarcóptica (Sarcoptes spp) e infestaciones para ácaros Otodectes spp. Bravecto puede administrarse directamente o con la comida. Composición: Cada gramo contiene: Fluralaner (micronizado) 136,4 mg, Excipientes csp10g.',
        'Su fórmula eliminará eficiente y eficazmente parásitos como pulgas y garrapatas, es un antiparasitario de rápida acción, tiene una alta palatabilidad que facilitará el suministro. Gracias a su rico sabor los perros lo ingieren voluntariamente.',
        'BVPG40',
        3,
        8
    ),
    (
        16,
        'Attack Para Perros Hasta De 5 Kg',
        28590,
        '5 mililitro',
        '0',
        'Attack para perros hasta de 5 kg, Para perros antiparasitario externo, prevención y tratamiento de infestaciones por pulgas (ctenocephalides canis/felis) y garrapatas (rhipicephalus sanguineus), para repeler moscas y mosquitos.',
        'Antiparasitario externo, prevención y tratamiento de infestaciones por pulgas (Ctenocephalides canis/felis) y garrapatas (Rhipicephalus sanguineus), para repeler moscas y mosquitos. Imidacloprid 10mg/kg Cifenotrina 1 mg/kg.',
        'Antipulgas para perros de razas medianas de 15 a 35 kg, sus ingredientes son seguros para ti, tu mascota y tu familia, brinda protección hasta por 30 días, eficaz control de pulgas y garrapatas, fácil de administrar.',
        'APPP5',
        3,
        9
    ),
    (
        17,
        'Advocate Pipeta Gatos Grandes Hasta 8 Kg',
        41300,
        '0.8 mililitro',
        '0',
        'Advocate pipeta gatos grandes hasta 8 kg, Es un antipulgas para perros pequeños que elimina y previene la existencia de pulgas adultas y larvas presentes en tu mascota. tipo parásito garrapata, tipo mascota gato, tamaño mascota todos, etapa de vida adulto, tipo producto antipulgas solución tópica para uso externo únicamente. separe el pelo de la parte posterior de la cabeza del perro y aplique todo el contenido de la pipeta directamente sobre la piel del animal, una sola pipeta de aventaje.',
        'Endectoparasitario, larvas y pulgas, administrar desde las 9 semanas de vida y hasta los 8 kg de peso, composición imidacloprid 10 mg/ml, moxidectina 10 mg/ml, tratamiento de 4 semanas.',
        'Por tanto, el uso del medicamento debe basarse en la valoración de cada caso individual y en factores epidemiológicos locales sobre la sensibilidad de los parásitos para disminuir el riesgo de la selección de resistencias en el futuro. El uso del medicamento debe basarse en la confirmación mediante diagnóstico de la existencia de infecciones mixtas.\r\nTambién te puede interesar\r\n\r\n\r\n \r\n\r\n\r\n \r\n\r\n\r\n \r\n\r\n\r\n \r\n\r\n\r\n \r\n\r\n\r\n \r\nComplementa tu compra\r\nDog Chow Salud Visible Cachorros Minis Y Pequeños\r\nDog Chow Salud Visible Cachorros Minis Y Pequeños\r\n    \r\n\r\n$ 13,550\r\n$ 11,518\r\nADQUIÉRELA YA\r\n\r\n1KG  2KG 4KG 8KG 17KG\r\nDog Chow Salud Visible Cachorros Medianos Y Grandes\r\nDog Chow Salud Visible Cachorros Medianos Y Grandes\r\n    \r\n\r\n$ 12,920\r\n$ 10,982\r\nADQUIÉRELA YA\r\n\r\n1KG  2KG 4KG 8KG 17KG 22.7KG\r\nDog Chow Salud Visible Adultos Minis y Pequeños\r\nDog Chow Salud Visible Adultos Minis y Pequeños\r\n    \r\n\r\n$ 12,560\r\n$ 10,676\r\nADQUIÉRELA YA\r\n\r\n1KG  2KG 8KG 17KG 4KG\r\n\r\nSíguenos en:\r\n\r\n  \r\n\r\nACERCA DE LAIKA\r\n\r\nSobre Laika\r\n\r\nServicios\r\n\r\nTrabaja con nosotros\r\n\r\nBlog\r\n\r\nTérminos y condiciones\r\n\r\nLINKS DE INTERÉS\r\n\r\nPreguntas frecuentes\r\n\r\n¿Cómo comprar en Laika?\r\n\r\nPolítica de Privacidad\r\n\r\nContáctanos\r\n\r\nPolíticas de Entrega\r\n\r\nINFORMACIÓN\r\n\r\nTeléfono: 3009108496\r\n\r\nservicioclientes@laika.com.co\r\n\r\nBogotá D.C., Colombia\r\n\r\nSUBSCRÍBETE\r\n\r\nRecibe noticias y promociones al instante.\r\n\r\nCorreo electrónico\r\nHe leído y acepto las Políticas de privacidad.\r\n      \r\nCopyright © 2021 LAIKA - Derechos reservados\r\n\r\nAl navegar en este sitio web aceptas las cookies que utilizamos para mejorar tu experiencia. Más información.',
        'APGG8',
        3,
        10
    ),
    (
        18,
        'Feliway Spray',
        68580,
        '60 mililitro',
        '0',
        'Feliway spray 60 ml, Es un calmante para tu mascota ideal para salidas o en casa, hace que los viajes y las visitas al veterinario sean menos estresantes, permite un manejo conveniente y específico de las áreas marcadas por tu gato con orina o arañazos en tu hogar. para el viaje en carro, rocíe en el cargador de tu gato y vuelve a aplicar cada 4 horas, espera 10 minutos después de rociar antes de colocar a tu pequeño dentro del cargador.',
        'En casa, simplemente rocía en la puerta y objetos alrededor de tu casa. Limpia los puntos marcados de orina primero y luego rocíe sobre las marcas, para evitar que vuelva a marcar territorio, nunca rocíes a tu gato, nunca rocíes en el cargador si tu gato está adentro.',
        'No rocíe sobre el rascador, ya que evitará que tu gato lo use, es un producto maravilloso que brinda calma a tu mascota., es ideal para gatos nerviosos, ayuda para que tu mascota no marque territorio.',
        'MFS60',
        3,
        11
    ),
    (
        19,
        'Gentax Oftálmico',
        15570,
        '10 mililitro',
        '0',
        'Gentax oftálmico 10 ml, Es un antibiótico en solución oftálmica indicada para el tratamiento de bacterias en el ojo. en caninos y felinos. tratamiento de infecciones bacterianas externas del ojo (conjuntiva y córnea), causadas por bacterias susceptibles a la gentamicina.',
        'GENTAMICINA SULFATO 3.0 mg, BETAMETASONA 1.0 mg, EXCIPIENTES C.S.P 1.0 Ml',
        'En Blefaritis aguda, crónica y alérgica, Conjuntivitis aguda, crónica y alérgica, Queratitis, queratoconjuntivitis, conjuntivitis alérgica estacional, Síndrome Überreiter (queratitis superficial crónica), reacciones inmunes en queratoplastias, Escleritis, síndrome de querato conjuntivitis proliferativa (en collies), Uveitis equina recurrente, Uveitis general (no supurativa y traumática), Corioretinitis y retinitis, desprendimiento retinal seroso, Neuritis óptica, Proptosis (exoftalmo) traumática del globo ocular y Linfoma maligno.',
        'MGO10',
        3,
        15
    ),
    (
        20,
        'FRONPET GATOS',
        14670,
        '0.32 mililitro',
        '0',
        'ECTOPARASITICIDA DE USO TOPICO.',
        'HECHO A BASE DE FIPRONIL AL 12.5%.',
        'COMBATE Y CONTROLA LA IMFESTACION DE PULGAS Y GARRAPATAS.',
        'MFG1',
        3,
        12
    ),
    (
        21,
        'Fiplex B12',
        8330,
        '10 mililitro',
        '0',
        'Fiplex b12 10 ml, Las vitaminas del complejo b que contiene fiplex b12 son coadyuvantes en el tratamiento y en la convalecencia de enfermedades infecciosas, parasitarias y virales. adicionalmente estimulan el apetito.',
        'Composición por cada 1mL: TiaminaFiplexb12 HCL 10mg + Riboflavina 5 Fosfato 6mg + Piridoxina HCL 5mg + Vitamina B12 0.05mg + nicotinamida 80mg + Pantenol 10mg',
        'Juegan un papel importante en el metabolismo de los carbohidratos, aminoácidos y grasas. La Riboflavina por su lado tiene un papel central en procesos de respiración mitocondrial y fosforilación oxidativa. Con el aporte de Piridoxina se trata y evita trastornos metabólicos como la homocistinuria, con el aporte de Cianocobalamina se trata y previene la anemia perniciosa, el deficit de alguna de estas vitaminas puede causar serios trastornos gastrointestinales, FIPLEX B12 cuenta con elementos indispensables para evitar y tratar dichos trastornos.\r\nTambién te puede interesar\r\n\r\n\r\n \r\n\r\n\r\n \r\n\r\n\r\n \r\n\r\n\r\n \r\n\r\n\r\n \r\n\r\n\r\n \r\nComplementa tu compra\r\n10%\r\nPurina Proplan Gatitos Con Optistart\r\nPurina Proplan Gatitos Con Optistart\r\n    \r\n\r\n$ 45,819Antes\r\n$ 50,910\r\n$ 43,274\r\nADQUIÉRELA YA\r\n\r\n1KG  3KG 7.5KG\r\n10%\r\nPurina Proplan Gatos Esterilizados Con Optirenal\r\nPurina Proplan Gatos Esterilizados Con Optirenal\r\n    \r\n\r\n$ 113,751Antes\r\n$ 126,390\r\n$ 107,432\r\nADQUIÉRELA YA\r\n\r\n3KG  1KG\r\n10%\r\nPurina Proplan Gatos Calorías Reducidas\r\nPurina Proplan Gatos Calorías Reducidas\r\n    \r\n\r\n$ 47,970Antes\r\n$ 53,300\r\n$ 45,305\r\nADQUIÉRELA YA\r\n\r\n1KG  3KG\r\n\r\nSíguenos en:\r\n\r\n  \r\n\r\nACERCA DE LAIKA\r\n\r\nSobre Laika\r\n\r\nServicios\r\n\r\nTrabaja con nosotros\r\n\r\nBlog\r\n\r\nTérminos y condiciones\r\n\r\nLINKS DE INTERÉS\r\n\r\nPreguntas frecuentes\r\n\r\n¿Cómo comprar en Laika?\r\n\r\nPolítica de Privacidad\r\n\r\nContáctanos\r\n\r\nPolíticas de Entrega\r\n\r\nINFORMACIÓN\r\n\r\nTeléfono: 3009108496\r\n\r\nservicioclientes@laika.com.co\r\n\r\nBogotá D.C., Colombia\r\n\r\nSUBSCRÍBETE\r\n\r\nRecibe noticias y promociones al instante.\r\n\r\nCorreo electrónico\r\nHe leído y acepto las Políticas de privacidad.\r\n      \r\nCopyright © 2021 LAIKA - Derechos reservados\r\n\r\nAl navegar en este sitio web aceptas las cookies que utilizamos para mejorar tu experiencia. Más información.',
        'MFB12',
        3,
        14
    ),
    (
        22,
        'Petys Shampoo Repelente De Pulgas',
        12780,
        '150 mililitro',
        '0',
        'Petys shampoo repelente de pulgas, Petstages wobble pond es un rascador de gatos diseñado con características que trabajan para entretener y entretener a su gato.',
        'El Shampoo con repelente de pulgas para perros Petys de Familia será una excelente opción para mantener la limpieza e higiene de tu perro y al mismo tiempo prevenirlo del contagio con estos parásitos externos. Tiene una agradable fragancia que se quedará en el pelaje por más tiempo y su fórmula es hipoalergénica así que es apto para perros con pieles más sensibles.\r\nTambién te puede interesar',
        'Su fragancia es natural y será el medio efectivo para decirle adios a las pulgas y hola a la limpieza. s un shampoo con acción repelente de pulgas ideal para perros de todas las razas. Con fórmula hipoalergénica, tiene una rica fragancia y aroma spring.',
        'PSRP1',
        4,
        16
    ),
    (
        23,
        'Shampoo Petys Limpieza Y Suavidad',
        11070,
        '150 mililitro',
        '0',
        'Shampoo petys limpieza y suavidad, Es el producto ideal para las mascotas, perros y gatos, porque protege y cuida el pelo de tu mascota, es hipo alergénico, reduce las probabilidades de generar alergias o afecciones en la piel.',
        'Contiene ingredientes naturales como glicerina, pantenol y aloe vera.',
        'Dejan el pelo suave brillante y con un agradable aroma.',
        'SPLS2',
        4,
        16
    ),
    (
        24,
        'Talco CanAmor Desodorante Gatos',
        12591,
        '100 Gr',
        '0',
        'Talco can amor desodorante gatos, de uso externo para gatos de todas las razas, es ideal para eliminar hongos y bacterias además garantiza la higiene del animal entre baños.',
        'Limpia y desodoriza el pelo de las mascotas. Baño seco que brinda protección y un agradable olor.',
        'Controla bacterias y hongos de la piel, exclusiva fragancia a bebé, aroma agradable, baño seco, especial uso entre baños, brinda sensación limpieza, sin parabenos.',
        'TCDG1',
        4,
        17
    ),
    (
        25,
        'Shampoo CanAmor Arbol De Te Gatos',
        16380,
        '230 mililitros',
        '0',
        'Shampoo cosmético de uso tópico, indicado en perros y gatos de todas las razas el lavado y la limpieza del pelo.',
        'Con Aloe vera, que ayuda a la hidratación del pelaje.',
        'Con aceite árbol de té, que posee propiedades calmantes , antisépticas y antinflamatorias.',
        'SCAG1',
        4,
        17
    ),
    (
        26,
        'Pañitos Húmedos Dinky Para Mascotas',
        6990,
        '35 unidades',
        '0',
        'Pañitos húmedos dinky para mascotas, Enriquecidos con aloe vera, sin alcohol, utiliza nuestros nuevos paños húmedos para mascotas dinky un amigo fiel para mantener limpio a tu #amigo fiel entre cada baño.',
        'Tienen una suave fragancia que inspira espacios y mascotas limpias.',
        'Formulados con control olor y fragancia fresca, higiénicos y desechables, control de olor, exquisita Fragancia, para Uso Diario',
        'PHDM1',
        4,
        19
    ),
    (
        27,
        'Baño Seco Dinky Espuma Gato Adulto',
        18540,
        '200 mililitros',
        '0',
        'Producto en espuma para limpiar a la mascota sin necesidad de agua',
        'Con extractos de caléndula y avena y libre de parabenos Gato adulto presentación : 200ml',
        'Limpia, hidrata y sin necesidad de agua',
        'BSDE1',
        4,
        19
    ),
    (
        28,
        'Loción Felina',
        13950,
        '100 mililitro',
        '0',
        'Loción felina, Con aloe vera: da fuerza brillo y vitalidad al pelo de las mascotas. extracto de menta: refresca la piel de las mascotas.',
        'Contiene Glicerina, que hidrata y suavisa la piel de las mascotas y da brillo.',
        'Delicada fragancia a talco de bebé. Facilita el proceso de convivencia con las mascotas en su entorno familiar. Producto no tóxico para gatos de todas las razas, en todas las etapas de la vida. Agradable y suave aroma.',
        'MLFG1',
        4,
        18
    ),
    (
        29,
        'Esqueleto Bordado Rosado Princess',
        9702,
        'XXS',
        '0',
        'Esqueleto bordado Police, tu perrito fresco y a la moda con su camiseta esqueleto hecha en algodón, estampados lindos y tiernos para el rey de la casa.',
        'Estampados lindos y tiernos para el rey de la casa. Medidas Talla XXS Largo 18 Cm Ancho 13 Cm, XS Largo 20 Cm Ancho 14 Cm, S Largo 24 Cm Ancho 18 Cm, M Largo 25 Cm Ancho 18 Cm, L Largo 29 Cm Ancho 22 Cm , XL Largo 35 Cm Ancho 24 Cm, XXL Largo 38,5 Cm Ancho 27 Cm',
        'Perfectas para clima cálido para estar en casa, prenda delicada, preferible lavar a mano.',
        'EBRP1',
        2,
        21
    ),
    (
        30,
        'Juguete Plástico Gallina Gigante',
        20950,
        'Extra Grande ',
        '0',
        'Juguete plástico gallina gigante argos extra grande, Juguete suave de alta resistencia, no se rompe con facilidad. no olvides buscar juguetes que sean del mismo tamaño o más grandes que la boca de tu perro.',
        'Recuerda que el juego es fundamental para el bienestar físico y emocional de tu perro. Tener algo que morder alivia el estrés y ayudará a tu perro a tranquilizarse.',
        'Material libre de sustancias nocivas, resiste los mordisqueos y arañazos de tu perro.',
        'JPGG1',
        2,
        21
    ),
    (
        31,
        'Pelota Lazo Mediana',
        4590,
        'Pequeña-azul',
        '0',
        'Pelota lazo mediana en colores azul, lila, naranja, roja, verde, resistente, especial para tu mascota, los mejores juguetes para tu mascota, disponible en varios colores, según disponibilidad.',
        'No olvides buscar juguetes que sean del mismo tamaño o más grandes que la boca de tu perro. Recuerda que el juego es fundamental para el bienestar físico y emocional de tu perro.',
        'Recuerda que el juego es fundamental para el bienestar físico y emocional de tu perro.',
        'PLM1',
        2,
        22
    ),
    (
        32,
        'Traílla Confort Ahogo',
        31450,
        'Mediana',
        '0',
        'Traílla confort ahogo mediana, Tela acolchada, velcro, reata y deia argolla. está fabricado con materiales de calidad como lo son la reata de nylon y los herrajes metálicos, gracias a su hebilla podrás ajustar el tamaño deseado dependiendo del grosor del cuello.',
        'Es una trailla fuerte y resistente que será ideal para brindar seguridad durante los paseos.',
        'Es un collar elaborado con materiales de muy buena calidad, collar producido con materiales 100% colombiano, ideal para mascotas pequeñas o medianas.',
        'TCAM1',
        2,
        22
    ),
    (
        33,
        'Toros Animal Shop Correa + Collar',
        40700,
        'M',
        '0',
        'Piñas animal shop, Correa - collar, material de poliéster totalmente reforzado, utilizamos herrajes de la más alta calidad para así poder garantizar nuestros productos a nuestros clientes, chapas en plásticos de alto impacto, triple de seguridad, materiales 100 % colombianos. Correa tallas: L - largo mín. 82 cm / largo máx. 135 cm - 2,5 cm ancho. Correa tallas: M - largo mín. 82 cm / largo máx. 135 cm - 2,5 cm ancho. Correa tallas: S – Ancho largo mín. 82 cm / largo máx. 135 cm – 2.5 cm ancho. Correa tallas: S - Angosto largo mín. 82 cm / largo máx. 135 cm - 2 cm ancho. Correa tallas: angosto largo mín. 82 cm / largo máx. 135 cm 2 cm de ancho. Collar Talla: L - largo mín. 40 cm / largo máx. 65 cm. / 2.5 cm de ancho. Collar Tallas: M largo mín. 35 cm / largo máx. 55 cm / 2.5 cm de ancho. Collar Tallas: S Ancho - largo mín. 28cm / largo máx. 42 cm / 2.5 cm de ancho. Collar Tallas: S Angosto - largo mín. 26 cm / largo máx. 39 cm / 2 cm de ancho. Collar Tallas: XS largo mín. 20 cm / largo máx. 29 cm / 2cm de ancho.',
        'Preciosas correas y collares de perro hecho en poliester, es de moda perfecto para los perros, tienen un estilo sofisticado y moderno, están hechos de materiales de muy alta calidad para garantizar una durabilidad y resistencia.',
        'Están hechos de materiales de muy alta calidad para garantizar una durabilidad y resistencia.',
        'TASC1',
        1,
        24
    ),
    (
        34,
        'Cargador Tipo Morral En Lona',
        63000,
        'AZUL',
        '0',
        'Cargador tipo morral en lona azul y rojo, para perro pequeño o gatos, con cuerpo en espuma que ayuda a evitar impactos debido al movimiento.',
        'Puedes cargarlo en la mano o en el hombro, cuenta con base sólida para brindar soporte y comodidad a tu mascota. Medidas Alto 24 Cm - Ancho 31 Cm - Fondo 42 Cm',
        'Cuenta con bolsillos para que transportes accesorios y/o comida de tu mascota.',
        'CTML1',
        2,
        21
    ),
    (
        35,
        'Correa De Extensión Doble',
        25000,
        'ROJA',
        '0',
        'Correa de extensión doble unidad, Correa extensión doble para perros con reforzada con cable en acero',
        'Es una correa impermeable y muy resistente, adecuada para perros de todos los tamanos. Colores: Surtido Medidas: Largo 80cm.',
        'Poliuretano reforzado con cable interno en acero, Clasica y funcional correa en poliuretano con gancho de seguridad para pasear con 2 perros de forma segura.',
        'CEDD1',
        2,
        25
    ),
    (
        36,
        'Elefante Interior Para Botella De Agua',
        34142,
        'Unidad',
        '0',
        'Elefante interior para botella de agua, Los juguetes de peluche son perfectos para cachorros gracias a su suavidad y calidez.',
        'Además, son los que menos riesgo conllevan de obstrucciones intestinales, pues están hechos de algodón en caso de que el perro ingiera un trozo.',
        'Cualidades idóneas para no dañar su dentadura en desarrollo, tienen un pito que hace que sea atractivo para ellos.',
        'EIPB1',
        2,
        20
    );

/*!40000 ALTER TABLE `producto` ENABLE KEYS */
;

/*!UNLOCK TABLES*/
;

--
-- Dumping data for table `serviciopeluqueria`
--
/*!LOCK TABLES `serviciopeluqueria` WRITE*/
;

/*!40000 ALTER TABLE `serviciopeluqueria` DISABLE KEYS */
;

INSERT INTO
    `serviciopeluqueria`
VALUES
    (1, 'Corte de uñas'),
    (2, 'Limpieza de oídos'),
    (3, 'Enjuegue de dientes '),
    (4, 'Champú antipulgas'),
    (5, 'Desengrasante '),
    (6, 'Drenaje de glandulas perianales'),
    (7, 'Enjuague con rinse');

/*!40000 ALTER TABLE `serviciopeluqueria` ENABLE KEYS */
;

/*!UNLOCK TABLES*/
;

--
-- Dumping data for table `tipomascota`
--
/*!LOCK TABLES `tipomascota` WRITE*/
;

/*!40000 ALTER TABLE `tipomascota` DISABLE KEYS */
;

INSERT INTO
    `tipomascota`
VALUES
    (1, 'Perro '),
    (2, 'Gato');

/*!40000 ALTER TABLE `tipomascota` ENABLE KEYS */
;

/*!UNLOCK TABLES*/
;

--
-- Dumping data for table `usuario`
--
/*!LOCK TABLES `usuario` WRITE*/
;

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */
;

/*!40000 ALTER TABLE `usuario` ENABLE KEYS */
;

/*!UNLOCK TABLES*/
;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */
;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */
;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */
;

/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */
;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */
;

/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */
;

/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */
;

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */
;

-- Dump completed on 2021-03-01 11:48:54