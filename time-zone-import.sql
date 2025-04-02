/*********************************************************
  1) CREACIÓN DE LA TABLA app_time_zone_coords
     (con lat/long)
**********************************************************/
CREATE TABLE IF NOT EXISTS `app_time_zone_coords` (
  `id` INT(5) NOT NULL,
  `countryCode` CHAR(2) NOT NULL DEFAULT '',
  `countryName` VARCHAR(255) NOT NULL DEFAULT '',
  `timeZone` VARCHAR(255) NOT NULL DEFAULT '',
  `gmtOffset` VARCHAR(50) NOT NULL,
  `latitude` DECIMAL(9,6) DEFAULT NULL,
  `longitude` DECIMAL(9,6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_countryName` (`countryName`),
  KEY `idx_countryCode` (`countryCode`),
  KEY `idx_timeZone` (`timeZone`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

-- IMPORTANTE: Si ya tenías la tabla con este nombre,
-- bórrala o renómbrala antes de ejecutar lo anterior.
-- DROP TABLE IF EXISTS `app_time_zone_coords`;


/*********************************************************
  2) INSERT DE REGISTROS (1 a 220)
     CON LATITUD/LONGITUD APROXIMADAS
**********************************************************/
INSERT INTO `app_time_zone_coords`
  (`id`,`countryCode`,`countryName`,`timeZone`,`gmtOffset`,`latitude`,`longitude`)
VALUES
-- 1)  AF / Asia/Kabul
(1, 'AF', 'Afghanistan', 'Asia/Kabul', 'UTC +04:30', 34.526010, 69.177680),

-- 2)  AL / Europe/Tirane
(2, 'AL', 'Albania', 'Europe/Tirane', 'UTC +01:00', 41.327500, 19.818890),

-- 3)  DZ / Africa/Algiers
(3, 'DZ', 'Algeria', 'Africa/Algiers', 'UTC +01:00', 36.753770, 3.058760),

-- 4)  AS / Pacific/Pago_Pago
(4, 'AS', 'American Samoa', 'Pacific/Pago_Pago', 'UTC -11:00', -14.275630, -170.702040),

-- 5)  AD / Europe/Andorra
(5, 'AD', 'Andorra', 'Europe/Andorra', 'UTC +01:00', 42.506317, 1.521835),

-- 6)  AO / Africa/Luanda
(6, 'AO', 'Angola', 'Africa/Luanda', 'UTC +01:00', -8.838330, 13.234440),

-- 7)  AI / America/Anguilla
(7, 'AI', 'Anguilla', 'America/Anguilla', 'UTC -04:00', 18.220554, -63.068615),

-- 8)  AQ / Antarctica/Casey
(8, 'AQ', 'Antarctica', 'Antarctica/Casey', 'UTC +11:00', -66.281800, 110.527600),

-- 9)  AQ / Antarctica/Davis
(9, 'AQ', 'Antarctica', 'Antarctica/Davis', 'UTC +07:00', -68.576600, 77.967400),

-- 10) AQ / Antarctica/DumontDUrville
(10, 'AQ', 'Antarctica', 'Antarctica/DumontDUrville', 'UTC +10:00', -66.663330, 140.001990),

-- 11) AQ / Antarctica/Mawson
(11, 'AQ', 'Antarctica', 'Antarctica/Mawson', 'UTC +05:00', -67.602700, 62.873800),

-- 12) AQ / Antarctica/McMurdo
(12, 'AQ', 'Antarctica', 'Antarctica/McMurdo', 'UTC +13:00', -77.846000, 166.668000),

-- 13) AQ / Antarctica/Palmer
(13, 'AQ', 'Antarctica', 'Antarctica/Palmer', 'UTC -03:00', -64.774100, -64.053700),

-- 14) AQ / Antarctica/Rothera
(14, 'AQ', 'Antarctica', 'Antarctica/Rothera', 'UTC -03:00', -67.568333, -68.123611),

-- 15) AQ / Antarctica/Syowa
(15, 'AQ', 'Antarctica', 'Antarctica/Syowa', 'UTC +03:00', -69.008600, 39.590800),

-- 16) AQ / Antarctica/Troll
(16, 'AQ', 'Antarctica', 'Antarctica/Troll', 'UTC', -72.016667, 2.533333),

-- 17) AQ / Antarctica/Vostok
(17, 'AQ', 'Antarctica', 'Antarctica/Vostok', 'UTC +06:00', -78.464000, 106.832500),

-- 18) AG / America/Antigua
(18, 'AG', 'Antigua and Barbuda', 'America/Antigua', 'UTC -04:00', 17.120963, -61.843300),

-- 19) AR / America/Argentina/Buenos_Aires
(19, 'AR', 'Argentina', 'America/Argentina/Buenos_Aires', 'UTC -03:00', -34.603722, -58.381592),

-- 20) AR / America/Argentina/Catamarca
(20, 'AR', 'Argentina', 'America/Argentina/Catamarca', 'UTC -03:00', -28.469570, -65.779530),

-- 21) AR / America/Argentina/Cordoba
(21, 'AR', 'Argentina', 'America/Argentina/Cordoba', 'UTC -03:00', -31.420083, -64.188776),

-- 22) AR / America/Argentina/Jujuy
(22, 'AR', 'Argentina', 'America/Argentina/Jujuy', 'UTC -03:00', -24.194570, -65.297120),

-- 23) AR / America/Argentina/La_Rioja
(23, 'AR', 'Argentina', 'America/Argentina/La_Rioja', 'UTC -03:00', -29.413500, -66.856460),

-- 24) AR / America/Argentina/Mendoza
(24, 'AR', 'Argentina', 'America/Argentina/Mendoza', 'UTC -03:00', -32.889458, -68.845840),

-- 25) AR / America/Argentina/Rio_Gallegos
(25, 'AR', 'Argentina', 'America/Argentina/Rio_Gallegos', 'UTC -03:00', -51.622608, -69.218127),

-- 26) AR / America/Argentina/Salta
(26, 'AR', 'Argentina', 'America/Argentina/Salta', 'UTC -03:00', -24.782932, -65.423317),

-- 27) AR / America/Argentina/San_Juan
(27, 'AR', 'Argentina', 'America/Argentina/San_Juan', 'UTC -03:00', -31.537500, -68.536390),

-- 28) AR / America/Argentina/San_Luis
(28, 'AR', 'Argentina', 'America/Argentina/San_Luis', 'UTC -03:00', -33.295010, -66.335630),

-- 29) AR / America/Argentina/Tucuman
(29, 'AR', 'Argentina', 'America/Argentina/Tucuman', 'UTC -03:00', -26.808285, -65.217590),

-- 30) AR / America/Argentina/Ushuaia
(30, 'AR', 'Argentina', 'America/Argentina/Ushuaia', 'UTC -03:00', -54.801912, -68.302951),

-- 31) AM / Asia/Yerevan
(31, 'AM', 'Armenia', 'Asia/Yerevan', 'UTC +04:00', 40.179188, 44.499104),

-- 32) AW / America/Aruba
(32, 'AW', 'Aruba', 'America/Aruba', 'UTC -04:00', 12.521110, -69.968338),

-- 33) AU / Antarctica/Macquarie
(33, 'AU', 'Australia', 'Antarctica/Macquarie', 'UTC +11:00', -54.499800, 158.943000),

-- 34) AU / Australia/Adelaide
(34, 'AU', 'Australia', 'Australia/Adelaide', 'UTC +10:30', -34.928660, 138.598630),

-- 35) AU / Australia/Brisbane
(35, 'AU', 'Australia', 'Australia/Brisbane', 'UTC +10:00', -27.469770, 153.025131),

-- 36) AU / Australia/Broken_Hill
(36, 'AU', 'Australia', 'Australia/Broken_Hill', 'UTC +10:30', -31.965560, 141.451240),

-- 37) AU / Australia/Darwin
(37, 'AU', 'Australia', 'Australia/Darwin', 'UTC +09:30', -12.462827, 130.841782),

-- 38) AU / Australia/Eucla
(38, 'AU', 'Australia', 'Australia/Eucla', 'UTC +08:45', -31.677300, 128.888000),

-- 39) AU / Australia/Hobart
(39, 'AU', 'Australia', 'Australia/Hobart', 'UTC +11:00', -42.882508, 147.328123),

-- 40) AU / Australia/Lindeman
(40, 'AU', 'Australia', 'Australia/Lindeman', 'UTC +10:00', -20.455000, 149.046000),

-- 41) AU / Australia/Lord_Howe
(41, 'AU', 'Australia', 'Australia/Lord_Howe', 'UTC +11:00', -31.540740, 159.076970),

-- 42) AU / Australia/Melbourne
(42, 'AU', 'Australia', 'Australia/Melbourne', 'UTC +11:00', -37.813629, 144.963058),

-- 43) AU / Australia/Perth
(43, 'AU', 'Australia', 'Australia/Perth', 'UTC +08:00', -31.952312, 115.861309),

-- 44) AU / Australia/Sydney
(44, 'AU', 'Australia', 'Australia/Sydney', 'UTC +11:00', -33.868820, 151.209290),

-- 45) AT / Europe/Vienna
(45, 'AT', 'Austria', 'Europe/Vienna', 'UTC +01:00', 48.208174, 16.373819),

-- 46) AZ / Asia/Baku
(46, 'AZ', 'Azerbaijan', 'Asia/Baku', 'UTC +04:00', 40.409264, 49.867092),

-- 47) BS / America/Nassau
(47, 'BS', 'Bahamas', 'America/Nassau', 'UTC -05:00', 25.044333, -77.350387),

-- 48) BH / Asia/Bahrain
(48, 'BH', 'Bahrain', 'Asia/Bahrain', 'UTC +03:00', 26.223497, 50.587557),

-- 49) BD / Asia/Dhaka
(49, 'BD', 'Bangladesh', 'Asia/Dhaka', 'UTC +06:00', 23.810331, 90.412521),

-- 50) BB / America/Barbados
(50, 'BB', 'Barbados', 'America/Barbados', 'UTC -04:00', 13.106954, -59.613158),

-- 51) BY / Europe/Minsk
(51, 'BY', 'Belarus', 'Europe/Minsk', 'UTC +03:00', 53.904540, 27.561524),

-- 52) BE / Europe/Brussels
(52, 'BE', 'Belgium', 'Europe/Brussels', 'UTC +01:00', 50.850346, 4.351721),

-- 53) BZ / America/Belize
(53, 'BZ', 'Belize', 'America/Belize', 'UTC -06:00', 17.504566, -88.196213),

-- 54) BJ / Africa/Porto-Novo
(54, 'BJ', 'Benin', 'Africa/Porto-Novo', 'UTC +01:00', 6.496857, 2.628852),

-- 55) BM / Atlantic/Bermuda
(55, 'BM', 'Bermuda', 'Atlantic/Bermuda', 'UTC -04:00', 32.299507, -64.790337),

-- 56) BT / Asia/Thimphu
(56, 'BT', 'Bhutan', 'Asia/Thimphu', 'UTC +06:00', 27.472792, 89.639286),

-- 57) BO / America/La_Paz
(57, 'BO', 'Bolivia, Plurinational State of', 'America/La_Paz', 'UTC -04:00', -16.489689, -68.119294),

-- 58) BQ / America/Kralendijk
(58, 'BQ', 'Bonaire, Sint Eustatius and Saba', 'America/Kralendijk', 'UTC -04:00', 12.144033, -68.264221),

-- 59) BA / Europe/Sarajevo
(59, 'BA', 'Bosnia and Herzegovina', 'Europe/Sarajevo', 'UTC +01:00', 43.856430, 18.413029),

-- 60) BW / Africa/Gaborone
(60, 'BW', 'Botswana', 'Africa/Gaborone', 'UTC +02:00', -24.628208, 25.923147),

-- 61) BR / America/Araguaina
(61, 'BR', 'Brazil', 'America/Araguaina', 'UTC -03:00', -7.192780, -48.207180),

-- 62) BR / America/Bahia
(62, 'BR', 'Brazil', 'America/Bahia', 'UTC -03:00', -12.977749, -38.501629),

-- 63) BR / America/Belem
(63, 'BR', 'Brazil', 'America/Belem', 'UTC -03:00', -1.455020, -48.502368),

-- 64) BR / America/Boa_Vista
(64, 'BR', 'Brazil', 'America/Boa_Vista', 'UTC -04:00', 2.819581, -60.673565),

-- 65) BR / America/Campo_Grande
(65, 'BR', 'Brazil', 'America/Campo_Grande', 'UTC -04:00', -20.469711, -54.620121),

-- 66) BR / America/Cuiaba
(66, 'BR', 'Brazil', 'America/Cuiaba', 'UTC -04:00', -15.601410, -56.097891),

-- 67) BR / America/Eirunepe
(67, 'BR', 'Brazil', 'America/Eirunepe', 'UTC -05:00', -6.660270, -69.873510),

-- 68) BR / America/Fortaleza
(68, 'BR', 'Brazil', 'America/Fortaleza', 'UTC -03:00', -3.731862, -38.526669),

-- 69) BR / America/Maceio
(69, 'BR', 'Brazil', 'America/Maceio', 'UTC -03:00', -9.649850, -35.708949),

-- 70) BR / America/Manaus
(70, 'BR', 'Brazil', 'America/Manaus', 'UTC -04:00', -3.119028, -60.021731),

-- 71) BR / America/Noronha
(71, 'BR', 'Brazil', 'America/Noronha', 'UTC -02:00', -3.855350, -32.423260),

-- 72) BR / America/Porto_Velho
(72, 'BR', 'Brazil', 'America/Porto_Velho', 'UTC -04:00', -8.761160, -63.903217),

-- 73) BR / America/Recife
(73, 'BR', 'Brazil', 'America/Recife', 'UTC -03:00', -8.054277, -34.881256),

-- 74) BR / America/Rio_Branco
(74, 'BR', 'Brazil', 'America/Rio_Branco', 'UTC -05:00', -9.974722, -67.824997),

-- 75) BR / America/Santarem
(75, 'BR', 'Brazil', 'America/Santarem', 'UTC -03:00', -2.438488, -54.699592),

-- 76) BR / America/Sao_Paulo
(76, 'BR', 'Brazil', 'America/Sao_Paulo', 'UTC -03:00', -23.550520, -46.633308),

-- 77) IO / Indian/Chagos
(77, 'IO', 'British Indian Ocean Territory', 'Indian/Chagos', 'UTC +06:00', -7.313480, 72.422400),

-- 78) BN / Asia/Brunei
(78, 'BN', 'Brunei Darussalam', 'Asia/Brunei', 'UTC +08:00', 4.903052, 114.939821),

-- 79) BG / Europe/Sofia
(79, 'BG', 'Bulgaria', 'Europe/Sofia', 'UTC +02:00', 42.697708, 23.321868),

-- 80) BF / Africa/Ouagadougou
(80, 'BF', 'Burkina Faso', 'Africa/Ouagadougou', 'UTC', 12.371428, -1.519660),

-- 81) BI / Africa/Bujumbura
(81, 'BI', 'Burundi', 'Africa/Bujumbura', 'UTC +02:00', -3.382203, 29.364401),

-- 82) KH / Asia/Phnom_Penh
(82, 'KH', 'Cambodia', 'Asia/Phnom_Penh', 'UTC +07:00', 11.556374, 104.928207),

-- 83) CM / Africa/Douala
(83, 'CM', 'Cameroon', 'Africa/Douala', 'UTC +01:00', 4.051056, 9.767868),

-- 84) CA / America/Atikokan
(84, 'CA', 'Canada', 'America/Atikokan', 'UTC -05:00', 48.759700, -91.621350),

-- 85) CA / America/Blanc-Sablon
(85, 'CA', 'Canada', 'America/Blanc-Sablon', 'UTC -04:00', 51.416667, -57.200000),

-- 86) CA / America/Cambridge_Bay
(86, 'CA', 'Canada', 'America/Cambridge_Bay', 'UTC -07:00', 69.117250, -105.049400),

-- 87) CA / America/Creston
(87, 'CA', 'Canada', 'America/Creston', 'UTC -07:00', 49.095277, -116.513056),

-- 88) CA / America/Dawson
(88, 'CA', 'Canada', 'America/Dawson', 'UTC -07:00', 64.060070, -139.432034),

-- 89) CA / America/Dawson_Creek
(89, 'CA', 'Canada', 'America/Dawson_Creek', 'UTC -07:00', 55.759880, -120.239490),

-- 90) CA / America/Edmonton
(90, 'CA', 'Canada', 'America/Edmonton', 'UTC -07:00', 53.546125, -113.493823),

-- 91) CA / America/Fort_Nelson
(91, 'CA', 'Canada', 'America/Fort_Nelson', 'UTC -07:00', 58.805000, -122.697200),

-- 92) CA / America/Glace_Bay
(92, 'CA', 'Canada', 'America/Glace_Bay', 'UTC -04:00', 46.196169, -59.956984),

-- 93) CA / America/Goose_Bay
(93, 'CA', 'Canada', 'America/Goose_Bay', 'UTC -04:00', 53.301900, -60.326700),

-- 94) CA / America/Halifax
(94, 'CA', 'Canada', 'America/Halifax', 'UTC -04:00', 44.648764, -63.575320),

-- 95) CA / America/Inuvik
(95, 'CA', 'Canada', 'America/Inuvik', 'UTC -07:00', 68.360055, -133.722999),

-- 96) CA / America/Iqaluit
(96, 'CA', 'Canada', 'America/Iqaluit', 'UTC -05:00', 63.746693, -68.516966),

-- 97) CA / America/Moncton
(97, 'CA', 'Canada', 'America/Moncton', 'UTC -04:00', 46.087816, -64.778231),

-- 98) CA / America/Rankin_Inlet
(98, 'CA', 'Canada', 'America/Rankin_Inlet', 'UTC -06:00', 62.807900, -92.085400),

-- 99) CA / America/Regina
(99, 'CA', 'Canada', 'America/Regina', 'UTC -06:00', 50.445211, -104.618894),

-- 100) CA / America/Resolute
(100, 'CA', 'Canada', 'America/Resolute', 'UTC -06:00', 74.691320, -94.829190),

-- 101) CA / America/St_Johns
(101, 'CA', 'Canada', 'America/St_Johns', 'UTC -03:30', 47.561509, -52.712577),

-- 102) CA / America/Swift_Current
(102, 'CA', 'Canada', 'America/Swift_Current', 'UTC -06:00', 50.288056, -107.793890),

-- 103) CA / America/Toronto
(103, 'CA', 'Canada', 'America/Toronto', 'UTC -05:00', 43.653225, -79.383186),

-- 104) CA / America/Vancouver
(104, 'CA', 'Canada', 'America/Vancouver', 'UTC -08:00', 49.282729, -123.120738),

-- 105) CA / America/Whitehorse
(105, 'CA', 'Canada', 'America/Whitehorse', 'UTC -07:00', 60.721187, -135.056845),

-- 106) CA / America/Winnipeg
(106, 'CA', 'Canada', 'America/Winnipeg', 'UTC -06:00', 49.895138, -97.138374),

-- 107) CA / America/Yellowknife
(107, 'CA', 'Canada', 'America/Yellowknife', 'UTC -07:00', 62.470892, -114.405993),

-- 108) CV / Atlantic/Cape_Verde
(108, 'CV', 'Cape Verde', 'Atlantic/Cape_Verde', 'UTC -01:00', 14.933050, -23.513327),

-- 109) KY / America/Cayman
(109, 'KY', 'Cayman Islands', 'America/Cayman', 'UTC -05:00', 19.322739, -81.240233),

-- 110) CF / Africa/Bangui
(110, 'CF', 'Central African Republic', 'Africa/Bangui', 'UTC +01:00', 4.394674, 18.558190),

-- 111) TD / Africa/Ndjamena
(111, 'TD', 'Chad', 'Africa/Ndjamena', 'UTC +01:00', 12.134846, 15.055742),

-- 112) CL / America/Punta_Arenas
(112, 'CL', 'Chile', 'America/Punta_Arenas', 'UTC -03:00', -53.154830, -70.911290),

-- 113) CL / America/Santiago
(113, 'CL', 'Chile', 'America/Santiago', 'UTC -03:00', -33.448891, -70.669266),

-- 114) CL / Pacific/Easter
(114, 'CL', 'Chile', 'Pacific/Easter', 'UTC -05:00', -27.125392, -109.349693),

-- 115) CN / Asia/Shanghai
(115, 'CN', 'China', 'Asia/Shanghai', 'UTC +08:00', 31.230391, 121.473701),

-- 116) CN / Asia/Urumqi
(116, 'CN', 'China', 'Asia/Urumqi', 'UTC +06:00', 43.825592, 87.616848),

-- 117) CX / Indian/Christmas
(117, 'CX', 'Christmas Island', 'Indian/Christmas', 'UTC +07:00', -10.491470, 105.632957),

-- 118) CC / Indian/Cocos
(118, 'CC', 'Cocos (Keeling) Islands', 'Indian/Cocos', 'UTC +06:30', -12.188834, 96.844399),

-- 119) CO / America/Bogota
(119, 'CO', 'Colombia', 'America/Bogota', 'UTC -05:00', 4.711000, -74.072100),

-- 120) KM / Indian/Comoro
(120, 'KM', 'Comoros', 'Indian/Comoro', 'UTC +03:00', -11.717216, 43.247314),

-- 121) CG / Africa/Brazzaville
(121, 'CG', 'Congo', 'Africa/Brazzaville', 'UTC +01:00', -4.263360, 15.242885),

-- 122) CD / Africa/Kinshasa
(122, 'CD', 'Congo, the Democratic Republic of the', 'Africa/Kinshasa', 'UTC +01:00', -4.441931, 15.266293),

-- 123) CD / Africa/Lubumbashi
(123, 'CD', 'Congo, the Democratic Republic of the', 'Africa/Lubumbashi', 'UTC +02:00', -11.660567, 27.479450),

-- 124) CK / Pacific/Rarotonga
(124, 'CK', 'Cook Islands', 'Pacific/Rarotonga', 'UTC -10:00', -21.229220, -159.776450),

-- 125) CR / America/Costa_Rica
(125, 'CR', 'Costa Rica', 'America/Costa_Rica', 'UTC -06:00', 9.928069, -84.090725),

-- 126) HR / Europe/Zagreb
(126, 'HR', 'Croatia', 'Europe/Zagreb', 'UTC +01:00', 45.815010, 15.981919),

-- 127) CU / America/Havana
(127, 'CU', 'Cuba', 'America/Havana', 'UTC -05:00', 23.113592, -82.366592),

-- 128) CW / America/Curacao
(128, 'CW', 'Curaçao', 'America/Curacao', 'UTC -04:00', 12.169570, -68.990020),

-- 129) CY / Asia/Famagusta
(129, 'CY', 'Cyprus', 'Asia/Famagusta', 'UTC +02:00', 35.122667, 33.950529),

-- 130) CY / Asia/Nicosia
(130, 'CY', 'Cyprus', 'Asia/Nicosia', 'UTC +02:00', 35.185566, 33.382276),

-- 131) CZ / Europe/Prague
(131, 'CZ', 'Czech Republic', 'Europe/Prague', 'UTC +01:00', 50.075538, 14.437800),

-- 132) CI / Africa/Abidjan
(132, 'CI', "Côte d'Ivoire", 'Africa/Abidjan', 'UTC', 5.345317, -4.024429),

-- 133) DK / Europe/Copenhagen
(133, 'DK', 'Denmark', 'Europe/Copenhagen', 'UTC +01:00', 55.676098, 12.568337),

-- 134) DJ / Africa/Djibouti
(134, 'DJ', 'Djibouti', 'Africa/Djibouti', 'UTC +03:00', 11.572077, 43.145647),

-- 135) DM / America/Dominica
(135, 'DM', 'Dominica', 'America/Dominica', 'UTC -04:00', 15.300000, -61.383333),

-- 136) DO / America/Santo_Domingo
(136, 'DO', 'Dominican Republic', 'America/Santo_Domingo', 'UTC -04:00', 18.486058, -69.931212),

-- 137) EC / America/Guayaquil
(137, 'EC', 'Ecuador', 'America/Guayaquil', 'UTC -05:00', -2.183580, -79.889960),

-- 138) EC / Pacific/Galapagos
(138, 'EC', 'Ecuador', 'Pacific/Galapagos', 'UTC -06:00', -0.953769, -89.617854),

-- 139) EG / Africa/Cairo
(139, 'EG', 'Egypt', 'Africa/Cairo', 'UTC +02:00', 30.044420, 31.235712),

-- 140) SV / America/El_Salvador
(140, 'SV', 'El Salvador', 'America/El_Salvador', 'UTC -06:00', 13.692940, -89.218191),

-- 141) GQ / Africa/Malabo
(141, 'GQ', 'Equatorial Guinea', 'Africa/Malabo', 'UTC +01:00', 3.750000, 8.783333),

-- 142) ER / Africa/Asmara
(142, 'ER', 'Eritrea', 'Africa/Asmara', 'UTC +03:00', 15.322877, 38.925052),

-- 143) EE / Europe/Tallinn
(143, 'EE', 'Estonia', 'Europe/Tallinn', 'UTC +02:00', 59.436962, 24.753574),

-- 144) ET / Africa/Addis_Ababa
(144, 'ET', 'Ethiopia', 'Africa/Addis_Ababa', 'UTC +03:00', 8.980603, 38.757759),

-- 145) FK / Atlantic/Stanley
(145, 'FK', 'Falkland Islands (Malvinas)', 'Atlantic/Stanley', 'UTC -03:00', -51.700000, -57.850001),

-- 146) FO / Atlantic/Faroe
(146, 'FO', 'Faroe Islands', 'Atlantic/Faroe', 'UTC', 62.034130, -6.999200),

-- 147) FJ / Pacific/Fiji
(147, 'FJ', 'Fiji', 'Pacific/Fiji', 'UTC +12:00', -18.124813, 178.450079),

-- 148) FI / Europe/Helsinki
(148, 'FI', 'Finland', 'Europe/Helsinki', 'UTC +02:00', 60.169857, 24.938379),

-- 149) FR / Europe/Paris
(149, 'FR', 'France', 'Europe/Paris', 'UTC +01:00', 48.856613, 2.352222),

-- 150) GF / America/Cayenne
(150, 'GF', 'French Guiana', 'America/Cayenne', 'UTC -03:00', 4.922420, -52.313453),

-- 151) PF / Pacific/Gambier
(151, 'PF', 'French Polynesia', 'Pacific/Gambier', 'UTC -09:00', -23.118448, -134.968353),

-- 152) PF / Pacific/Marquesas
(152, 'PF', 'French Polynesia', 'Pacific/Marquesas', 'UTC -09:30', -9.000000, -139.000000),

-- 153) PF / Pacific/Tahiti
(153, 'PF', 'French Polynesia', 'Pacific/Tahiti', 'UTC -10:00', -17.650920, -149.426042),

-- 154) TF / Indian/Kerguelen
(154, 'TF', 'French Southern Territories', 'Indian/Kerguelen', 'UTC +05:00', -49.350000, 70.216667),

-- 155) GA / Africa/Libreville
(155, 'GA', 'Gabon', 'Africa/Libreville', 'UTC +01:00', 0.416198, 9.467268),

-- 156) GM / Africa/Banjul
(156, 'GM', 'Gambia', 'Africa/Banjul', 'UTC', 13.454876, -16.579032),

-- 157) GE / Asia/Tbilisi
(157, 'GE', 'Georgia', 'Asia/Tbilisi', 'UTC +04:00', 41.715137, 44.827096),

-- 158) DE / Europe/Berlin
(158, 'DE', 'Germany', 'Europe/Berlin', 'UTC +01:00', 52.520008, 13.404954),

-- 159) DE / Europe/Busingen
(159, 'DE', 'Germany', 'Europe/Busingen', 'UTC +01:00', 47.697320, 8.690170),

-- 160) GH / Africa/Accra
(160, 'GH', 'Ghana', 'Africa/Accra', 'UTC', 5.603717, -0.186964),

-- 161) GI / Europe/Gibraltar
(161, 'GI', 'Gibraltar', 'Europe/Gibraltar', 'UTC +01:00', 36.140751, -5.353585),

-- 162) GR / Europe/Athens
(162, 'GR', 'Greece', 'Europe/Athens', 'UTC +02:00', 37.983810, 23.727539),

-- 163) GL / America/Danmarkshavn
(163, 'GL', 'Greenland', 'America/Danmarkshavn', 'UTC', 76.769195, -18.666668),

-- 164) GL / America/Nuuk
(164, 'GL', 'Greenland', 'America/Nuuk', 'UTC -03:00', 64.183470, -51.721570),

-- 165) GL / America/Scoresbysund
(165, 'GL', 'Greenland', 'America/Scoresbysund', 'UTC -01:00', 70.484810, -21.966310),

-- 166) GL / America/Thule
(166, 'GL', 'Greenland', 'America/Thule', 'UTC -04:00', 76.531197, -68.703253),

-- 167) GD / America/Grenada
(167, 'GD', 'Grenada', 'America/Grenada', 'UTC -04:00', 12.106015, -61.686253),

-- 168) GP / America/Guadeloupe
(168, 'GP', 'Guadeloupe', 'America/Guadeloupe', 'UTC -04:00', 16.267373, -61.550528),

-- 169) GU / Pacific/Guam
(169, 'GU', 'Guam', 'Pacific/Guam', 'UTC +10:00', 13.444304, 144.793732),

-- 170) GT / America/Guatemala
(170, 'GT', 'Guatemala', 'America/Guatemala', 'UTC -06:00', 14.634915, -90.506882),

-- 171) GG / Europe/Guernsey
(171, 'GG', 'Guernsey', 'Europe/Guernsey', 'UTC', 49.454110, -2.590010),

-- 172) GN / Africa/Conakry
(172, 'GN', 'Guinea', 'Africa/Conakry', 'UTC', 9.641185, -13.578401),

-- 173) GW / Africa/Bissau
(173, 'GW', 'Guinea-Bissau', 'Africa/Bissau', 'UTC', 11.880965, -15.617794),

-- 174) GY / America/Guyana
(174, 'GY', 'Guyana', 'America/Guyana', 'UTC -04:00', 6.801279, -58.155125),

-- 175) HT / America/Port-au-Prince
(175, 'HT', 'Haiti', 'America/Port-au-Prince', 'UTC -05:00', 18.594395, -72.307433),

-- 176) VA / Europe/Vatican
(176, 'VA', 'Holy See (Vatican City State)', 'Europe/Vatican', 'UTC +01:00', 41.902167, 12.453937),

-- 177) HN / America/Tegucigalpa
(177, 'HN', 'Honduras', 'America/Tegucigalpa', 'UTC -06:00', 14.081999, -87.206819),

-- 178) HK / Asia/Hong_Kong
(178, 'HK', 'Hong Kong', 'Asia/Hong_Kong', 'UTC +08:00', 22.319303, 114.169361),

-- 179) HU / Europe/Budapest
(179, 'HU', 'Hungary', 'Europe/Budapest', 'UTC +01:00', 47.497912, 19.040235),

-- 180) IS / Atlantic/Reykjavik
(180, 'IS', 'Iceland', 'Atlantic/Reykjavik', 'UTC', 64.146582, -21.942635),

-- 181) IN / Asia/Kolkata
(181, 'IN', 'India', 'Asia/Kolkata', 'UTC +05:30', 22.572645, 88.363892),

-- 182) ID / Asia/Jakarta
(182, 'ID', 'Indonesia', 'Asia/Jakarta', 'UTC +07:00', -6.208763, 106.845599),

-- 183) ID / Asia/Jayapura
(183, 'ID', 'Indonesia', 'Asia/Jayapura', 'UTC +09:00', -2.534247, 140.718132),

-- 184) ID / Asia/Makassar
(184, 'ID', 'Indonesia', 'Asia/Makassar', 'UTC +08:00', -5.147665, 119.432730),

-- 185) ID / Asia/Pontianak
(185, 'ID', 'Indonesia', 'Asia/Pontianak', 'UTC +07:00', -0.026330, 109.342503),

-- 186) IR / Asia/Tehran
(186, 'IR', 'Iran, Islamic Republic of', 'Asia/Tehran', 'UTC +03:30', 35.689198, 51.388974),

-- 187) IQ / Asia/Baghdad
(187, 'IQ', 'Iraq', 'Asia/Baghdad', 'UTC +03:00', 33.312805, 44.361488),

-- 188) IE / Europe/Dublin
(188, 'IE', 'Ireland', 'Europe/Dublin', 'UTC', 53.349805, -6.260310),

-- 189) IM / Europe/Isle_of_Man
(189, 'IM', 'Isle of Man', 'Europe/Isle_of_Man', 'UTC', 54.236107, -4.548056),

-- 190) IL / Asia/Jerusalem
(190, 'IL', 'Israel', 'Asia/Jerusalem', 'UTC +02:00', 31.768319, 35.213710),

-- 191) IT / Europe/Rome
(191, 'IT', 'Italy', 'Europe/Rome', 'UTC +01:00', 41.902782, 12.496366),

-- 192) JM / America/Jamaica
(192, 'JM', 'Jamaica', 'America/Jamaica', 'UTC -05:00', 18.017874, -76.809904),

-- 193) JP / Asia/Tokyo
(193, 'JP', 'Japan', 'Asia/Tokyo', 'UTC +09:00', 35.689487, 139.691711),

-- 194) JE / Europe/Jersey
(194, 'JE', 'Jersey', 'Europe/Jersey', 'UTC', 49.213680, -2.135210),

-- 195) JO / Asia/Amman
(195, 'JO', 'Jordan', 'Asia/Amman', 'UTC +03:00', 31.953949, 35.910635),

-- 196) KZ / Asia/Almaty
(196, 'KZ', 'Kazakhstan', 'Asia/Almaty', 'UTC +06:00', 43.222015, 76.851248),

-- 197) KZ / Asia/Aqtau
(197, 'KZ', 'Kazakhstan', 'Asia/Aqtau', 'UTC +05:00', 43.651909, 51.197514),

-- 198) KZ / Asia/Aqtobe
(198, 'KZ', 'Kazakhstan', 'Asia/Aqtobe', 'UTC +05:00', 50.283939, 57.166978),

-- 199) KZ / Asia/Atyrau
(199, 'KZ', 'Kazakhstan', 'Asia/Atyrau', 'UTC +05:00', 47.094495, 51.923119),

-- 200) KZ / Asia/Oral
(200, 'KZ', 'Kazakhstan', 'Asia/Oral', 'UTC +05:00', 51.227821, 51.386544),

-- 201) KZ / Asia/Qostanay
(201, 'KZ', 'Kazakhstan', 'Asia/Qostanay', 'UTC +06:00', 53.219556, 63.628571),

-- 202) KZ / Asia/Qyzylorda
(202, 'KZ', 'Kazakhstan', 'Asia/Qyzylorda', 'UTC +05:00', 44.847110, 65.482253),

-- 203) KE / Africa/Nairobi
(203, 'KE', 'Kenya', 'Africa/Nairobi', 'UTC +03:00', -1.286389, 36.817223),

-- 204) KI / Pacific/Kanton
(204, 'KI', 'Kiribati', 'Pacific/Kanton', 'UTC +13:00', -2.769097, -171.679568),

-- 205) KI / Pacific/Kiritimati
(205, 'KI', 'Kiribati', 'Pacific/Kiritimati', 'UTC +14:00', 1.872099, -157.427800),

-- 206) KI / Pacific/Tarawa
(206, 'KI', 'Kiribati', 'Pacific/Tarawa', 'UTC +12:00', 1.327803, 173.008987),

-- 207) KP / Asia/Pyongyang
(207, 'KP', "Korea, Democratic People's Republic of", 'Asia/Pyongyang', 'UTC +09:00', 39.039219, 125.762524),

-- 208) KR / Asia/Seoul
(208, 'KR', 'Korea, Republic of', 'Asia/Seoul', 'UTC +09:00', 37.566535, 126.977969),

-- 209) KW / Asia/Kuwait
(209, 'KW', 'Kuwait', 'Asia/Kuwait', 'UTC +03:00', 29.375859, 47.977405),

-- 210) KG / Asia/Bishkek
(210, 'KG', 'Kyrgyzstan', 'Asia/Bishkek', 'UTC +06:00', 42.874621, 74.569762),

-- 211) LA / Asia/Vientiane
(211, 'LA', "Lao People's Democratic Republic", 'Asia/Vientiane', 'UTC +07:00', 17.975706, 102.633104),

-- 212) LV / Europe/Riga
(212, 'LV', 'Latvia', 'Europe/Riga', 'UTC +02:00', 56.949649, 24.105186),

-- 213) LB / Asia/Beirut
(213, 'LB', 'Lebanon', 'Asia/Beirut', 'UTC +02:00', 33.893791, 35.501778),

-- 214) LS / Africa/Maseru
(214, 'LS', 'Lesotho', 'Africa/Maseru', 'UTC +02:00', -29.315179, 27.488389),

-- 215) LR / Africa/Monrovia
(215, 'LR', 'Liberia', 'Africa/Monrovia', 'UTC', 6.300774, -10.797185),

-- 216) LY / Africa/Tripoli
(216, 'LY', 'Libya', 'Africa/Tripoli', 'UTC +02:00', 32.887209, 13.191338),

-- 217) LI / Europe/Vaduz
(217, 'LI', 'Liechtenstein', 'Europe/Vaduz', 'UTC +01:00', 47.139182, 9.522765),

-- 218) LT / Europe/Vilnius
(218, 'LT', 'Lithuania', 'Europe/Vilnius', 'UTC +02:00', 54.687157, 25.279652),

-- 219) LU / Europe/Luxembourg
(219, 'LU', 'Luxembourg', 'Europe/Luxembourg', 'UTC +01:00', 49.815273, 6.129583),

-- 220) MO / Asia/Macau
(220, 'MO', 'Macao', 'Asia/Macau', 'UTC +08:00', 22.191968, 113.545227);

(221, 'MK', 'Macedonia, the Former Yugoslav Republic of', 'Europe/Skopje', 'UTC +01:00', 41.998100, 21.425400),

-- 222) MG / Indian/Antananarivo
(222, 'MG', 'Madagascar', 'Indian/Antananarivo', 'UTC +03:00', -18.879190, 47.507905),

-- 223) MW / Africa/Blantyre
(223, 'MW', 'Malawi', 'Africa/Blantyre', 'UTC +02:00', -15.786111, 35.005833),

-- 224) MY / Asia/Kuala_Lumpur
(224, 'MY', 'Malaysia', 'Asia/Kuala_Lumpur', 'UTC +08:00', 3.139003, 101.686855),

-- 225) MY / Asia/Kuching
(225, 'MY', 'Malaysia', 'Asia/Kuching', 'UTC +08:00', 1.553000, 110.359000),

-- 226) MV / Indian/Maldives
(226, 'MV', 'Maldives', 'Indian/Maldives', 'UTC +05:00', 4.175496, 73.509347),

-- 227) ML / Africa/Bamako
(227, 'ML', 'Mali', 'Africa/Bamako', 'UTC', 12.639232, -8.002889),

-- 228) MT / Europe/Malta
(228, 'MT', 'Malta', 'Europe/Malta', 'UTC +01:00', 35.898908, 14.514553),

-- 229) MH / Pacific/Kwajalein
(229, 'MH', 'Marshall Islands', 'Pacific/Kwajalein', 'UTC +12:00', 8.715900, 167.733200),

-- 230) MH / Pacific/Majuro
(230, 'MH', 'Marshall Islands', 'Pacific/Majuro', 'UTC +12:00', 7.116400, 171.373700),

-- 231) MQ / America/Martinique
(231, 'MQ', 'Martinique', 'America/Martinique', 'UTC -04:00', 14.641528, -61.024174),

-- 232) MR / Africa/Nouakchott
(232, 'MR', 'Mauritania', 'Africa/Nouakchott', 'UTC', 18.073530, -15.958237),

-- 233) MU / Indian/Mauritius
(233, 'MU', 'Mauritius', 'Indian/Mauritius', 'UTC +04:00', -20.348404, 57.552152),

-- 234) YT / Indian/Mayotte
(234, 'YT', 'Mayotte', 'Indian/Mayotte', 'UTC +03:00', -12.827500, 45.166244),

-- 235) MX / America/Bahia_Banderas
(235, 'MX', 'Mexico', 'America/Bahia_Banderas', 'UTC -06:00', 20.606800, -105.237200),

-- 236) MX / America/Cancun
(236, 'MX', 'Mexico', 'America/Cancun', 'UTC -05:00', 21.161908, -86.851527),

-- 237) MX / America/Chihuahua
(237, 'MX', 'Mexico', 'America/Chihuahua', 'UTC -06:00', 28.632996, -106.069100),

-- 238) MX / America/Ciudad_Juarez
(238, 'MX', 'Mexico', 'America/Ciudad_Juarez', 'UTC -07:00', 31.690364, -106.424547),

-- 239) MX / America/Hermosillo
(239, 'MX', 'Mexico', 'America/Hermosillo', 'UTC -07:00', 29.089186, -110.961647),

-- 240) MX / America/Matamoros
(240, 'MX', 'Mexico', 'America/Matamoros', 'UTC -06:00', 25.879720, -97.505189),

-- 241) MX / America/Mazatlan
(241, 'MX', 'Mexico', 'America/Mazatlan', 'UTC -07:00', 23.249415, -106.411142),

-- 242) MX / America/Merida
(242, 'MX', 'Mexico', 'America/Merida', 'UTC -06:00', 20.967370, -89.592586),

-- 243) MX / America/Mexico_City
(243, 'MX', 'Mexico', 'America/Mexico_City', 'UTC -06:00', 19.432608, -99.133209),

-- 244) MX / America/Monterrey
(244, 'MX', 'Mexico', 'America/Monterrey', 'UTC -06:00', 25.686614, -100.316113),

-- 245) MX / America/Ojinaga
(245, 'MX', 'Mexico', 'America/Ojinaga', 'UTC -06:00', 29.562350, -104.416209),

-- 246) MX / America/Tijuana
(246, 'MX', 'Mexico', 'America/Tijuana', 'UTC -08:00', 32.514946, -117.038247),

-- 247) FM / Pacific/Chuuk
(247, 'FM', 'Micronesia, Federated States of', 'Pacific/Chuuk', 'UTC +10:00', 7.451466, 151.843095),

-- 248) FM / Pacific/Kosrae
(248, 'FM', 'Micronesia, Federated States of', 'Pacific/Kosrae', 'UTC +11:00', 5.316000, 163.008000),

-- 249) FM / Pacific/Pohnpei
(249, 'FM', 'Micronesia, Federated States of', 'Pacific/Pohnpei', 'UTC +11:00', 6.977700, 158.240400),

-- 250) MD / Europe/Chisinau
(250, 'MD', 'Moldova, Republic of', 'Europe/Chisinau', 'UTC +02:00', 47.010453, 28.863810),

-- 251) MC / Europe/Monaco
(251, 'MC', 'Monaco', 'Europe/Monaco', 'UTC +01:00', 43.738417, 7.424616),

-- 252) MN / Asia/Choibalsan
(252, 'MN', 'Mongolia', 'Asia/Choibalsan', 'UTC +08:00', 48.072778, 114.536111),

-- 253) MN / Asia/Hovd
(253, 'MN', 'Mongolia', 'Asia/Hovd', 'UTC +07:00', 47.979156, 91.634756),

-- 254) MN / Asia/Ulaanbaatar
(254, 'MN', 'Mongolia', 'Asia/Ulaanbaatar', 'UTC +08:00', 47.921230, 106.918556),

-- 255) ME / Europe/Podgorica
(255, 'ME', 'Montenegro', 'Europe/Podgorica', 'UTC +01:00', 42.430420, 19.259363),

-- 256) MS / America/Montserrat
(256, 'MS', 'Montserrat', 'America/Montserrat', 'UTC -04:00', 16.741704, -62.191684),

-- 257) MA / Africa/Casablanca
(257, 'MA', 'Morocco', 'Africa/Casablanca', 'UTC +01:00', 33.573110, -7.589843),

-- 258) MA / Africa/El_Aaiun
(258, 'MA', 'Morocco', 'Africa/El_Aaiun', 'UTC +01:00', 27.125286, -13.162500),

-- 259) MZ / Africa/Maputo
(259, 'MZ', 'Mozambique', 'Africa/Maputo', 'UTC +02:00', -25.966663, 32.573188),

-- 260) MM / Asia/Yangon
(260, 'MM', 'Myanmar', 'Asia/Yangon', 'UTC +06:30', 16.840929, 96.173339),

-- 261) NA / Africa/Windhoek
(261, 'NA', 'Namibia', 'Africa/Windhoek', 'UTC +02:00', -22.560881, 17.065755),

-- 262) NR / Pacific/Nauru
(262, 'NR', 'Nauru', 'Pacific/Nauru', 'UTC +12:00', -0.533333, 166.916667),

-- 263) NP / Asia/Kathmandu
(263, 'NP', 'Nepal', 'Asia/Kathmandu', 'UTC +05:45', 27.717245, 85.323960),

-- 264) NL / Europe/Amsterdam
(264, 'NL', 'Netherlands', 'Europe/Amsterdam', 'UTC +01:00', 52.367984, 4.903561),

-- 265) NC / Pacific/Noumea
(265, 'NC', 'New Caledonia', 'Pacific/Noumea', 'UTC +11:00', -22.275801, 166.458000),

-- 266) NZ / Pacific/Auckland
(266, 'NZ', 'New Zealand', 'Pacific/Auckland', 'UTC +13:00', -36.848461, 174.763336),

-- 267) NZ / Pacific/Chatham
(267, 'NZ', 'New Zealand', 'Pacific/Chatham', 'UTC +13:45', -43.951379, -176.559732),

-- 268) NI / America/Managua
(268, 'NI', 'Nicaragua', 'America/Managua', 'UTC -06:00', 12.114993, -86.236174),

-- 269) NE / Africa/Niamey
(269, 'NE', 'Niger', 'Africa/Niamey', 'UTC +01:00', 13.511588, 2.125385),

-- 270) NG / Africa/Lagos
(270, 'NG', 'Nigeria', 'Africa/Lagos', 'UTC +01:00', 6.524379, 3.379206),

-- 271) NU / Pacific/Niue
(271, 'NU', 'Niue', 'Pacific/Niue', 'UTC -11:00', -19.054445, -169.867233),

-- 272) NF / Pacific/Norfolk
(272, 'NF', 'Norfolk Island', 'Pacific/Norfolk', 'UTC +12:00', -29.040835, 167.954712),

-- 273) MP / Pacific/Saipan
(273, 'MP', 'Northern Mariana Islands', 'Pacific/Saipan', 'UTC +10:00', 15.177801, 145.750967),

-- 274) NO / Europe/Oslo
(274, 'NO', 'Norway', 'Europe/Oslo', 'UTC +01:00', 59.913869, 10.752245),

-- 275) OM / Asia/Muscat
(275, 'OM', 'Oman', 'Asia/Muscat', 'UTC +04:00', 23.585890, 58.405923),

-- 276) PK / Asia/Karachi
(276, 'PK', 'Pakistan', 'Asia/Karachi', 'UTC +05:00', 24.860735, 67.001137),

-- 277) PW / Pacific/Palau
(277, 'PW', 'Palau', 'Pacific/Palau', 'UTC +09:00', 7.514980, 134.582520),

-- 278) PS / Asia/Gaza
(278, 'PS', 'Palestine, State of', 'Asia/Gaza', 'UTC +02:00', 31.501714, 34.466812),

-- 279) PS / Asia/Hebron
(279, 'PS', 'Palestine, State of', 'Asia/Hebron', 'UTC +02:00', 31.532569, 35.099826),

-- 280) PA / America/Panama
(280, 'PA', 'Panama', 'America/Panama', 'UTC -05:00', 8.982379, -79.519870),

-- 281) PG / Pacific/Bougainville
(281, 'PG', 'Papua New Guinea', 'Pacific/Bougainville', 'UTC +11:00', -6.233333, 155.566667),

-- 282) PG / Pacific/Port_Moresby
(282, 'PG', 'Papua New Guinea', 'Pacific/Port_Moresby', 'UTC +10:00', -9.443800, 147.180267),

-- 283) PY / America/Asuncion
(283, 'PY', 'Paraguay', 'America/Asuncion', 'UTC -03:00', -25.263740, -57.575926),

-- 284) PE / America/Lima
(284, 'PE', 'Peru', 'America/Lima', 'UTC -05:00', -12.046374, -77.042793),

-- 285) PH / Asia/Manila
(285, 'PH', 'Philippines', 'Asia/Manila', 'UTC +08:00', 14.599512, 120.984222),

-- 286) PN / Pacific/Pitcairn
(286, 'PN', 'Pitcairn', 'Pacific/Pitcairn', 'UTC -08:00', -24.376394, -128.324996),

-- 287) PL / Europe/Warsaw
(287, 'PL', 'Poland', 'Europe/Warsaw', 'UTC +01:00', 52.229676, 21.012229),

-- 288) PT / Atlantic/Azores
(288, 'PT', 'Portugal', 'Atlantic/Azores', 'UTC -01:00', 37.741248, -25.675593),

-- 289) PT / Atlantic/Madeira
(289, 'PT', 'Portugal', 'Atlantic/Madeira', 'UTC', 32.760707, -16.959472),

-- 290) PT / Europe/Lisbon
(290, 'PT', 'Portugal', 'Europe/Lisbon', 'UTC', 38.722253, -9.139337),

-- 291) PR / America/Puerto_Rico
(291, 'PR', 'Puerto Rico', 'America/Puerto_Rico', 'UTC -04:00', 18.220833, -66.590149),

-- 292) QA / Asia/Qatar
(292, 'QA', 'Qatar', 'Asia/Qatar', 'UTC +03:00', 25.354826, 51.183884),

-- 293) RO / Europe/Bucharest
(293, 'RO', 'Romania', 'Europe/Bucharest', 'UTC +02:00', 44.426767, 26.102538),

-- 294) RU / Asia/Anadyr
(294, 'RU', 'Russian Federation', 'Asia/Anadyr', 'UTC +12:00', 64.733333, 177.516667),

-- 295) RU / Asia/Barnaul
(295, 'RU', 'Russian Federation', 'Asia/Barnaul', 'UTC +07:00', 53.356998, 83.787594),

-- 296) RU / Asia/Chita
(296, 'RU', 'Russian Federation', 'Asia/Chita', 'UTC +09:00', 52.052000, 113.471000),

-- 297) RU / Asia/Irkutsk
(297, 'RU', 'Russian Federation', 'Asia/Irkutsk', 'UTC +08:00', 52.286974, 104.305018),

-- 298) RU / Asia/Kamchatka
(298, 'RU', 'Russian Federation', 'Asia/Kamchatka', 'UTC +12:00', 53.016667, 158.650000),

-- 299) RU / Asia/Khandyga
(299, 'RU', 'Russian Federation', 'Asia/Khandyga', 'UTC +09:00', 62.666667, 135.600000),

-- 300) RU / Asia/Krasnoyarsk
(300, 'RU', 'Russian Federation', 'Asia/Krasnoyarsk', 'UTC +07:00', 56.015283, 92.893247),

-- 301) RU / Asia/Magadan
(301, 'RU', 'Russian Federation', 'Asia/Magadan', 'UTC +11:00', 59.561480, 150.803470),

-- 302) RU / Asia/Novokuznetsk
(302, 'RU', 'Russian Federation', 'Asia/Novokuznetsk', 'UTC +07:00', 53.759622, 87.121570),

-- 303) RU / Asia/Novosibirsk
(303, 'RU', 'Russian Federation', 'Asia/Novosibirsk', 'UTC +07:00', 55.008353, 82.935733),

-- 304) RU / Asia/Omsk
(304, 'RU', 'Russian Federation', 'Asia/Omsk', 'UTC +06:00', 54.988480, 73.324236),

-- 305) RU / Asia/Sakhalin
(305, 'RU', 'Russian Federation', 'Asia/Sakhalin', 'UTC +11:00', 46.964167, 142.731667),

-- 306) RU / Asia/Srednekolymsk
(306, 'RU', 'Russian Federation', 'Asia/Srednekolymsk', 'UTC +11:00', 67.458333, 153.733333),

-- 307) RU / Asia/Tomsk
(307, 'RU', 'Russian Federation', 'Asia/Tomsk', 'UTC +07:00', 56.501039, 84.992451),

-- 308) RU / Asia/Ust-Nera
(308, 'RU', 'Russian Federation', 'Asia/Ust-Nera', 'UTC +10:00', 64.566667, 143.200000),

-- 309) RU / Asia/Vladivostok
(309, 'RU', 'Russian Federation', 'Asia/Vladivostok', 'UTC +10:00', 43.133722, 131.911297),

-- 310) RU / Asia/Yakutsk
(310, 'RU', 'Russian Federation', 'Asia/Yakutsk', 'UTC +09:00', 62.027223, 129.732223),

-- 311) RU / Asia/Yekaterinburg
(311, 'RU', 'Russian Federation', 'Asia/Yekaterinburg', 'UTC +05:00', 56.838926, 60.605703),

-- 312) RU / Europe/Astrakhan
(312, 'RU', 'Russian Federation', 'Europe/Astrakhan', 'UTC +04:00', 46.349683, 48.040763),

-- 313) RU / Europe/Kaliningrad
(313, 'RU', 'Russian Federation', 'Europe/Kaliningrad', 'UTC +02:00', 54.710426, 20.452214),

-- 314) RU / Europe/Kirov
(314, 'RU', 'Russian Federation', 'Europe/Kirov', 'UTC +03:00', 58.603533, 49.667976),

-- 315) RU / Europe/Moscow
(315, 'RU', 'Russian Federation', 'Europe/Moscow', 'UTC +03:00', 55.755826, 37.617299),

-- 316) RU / Europe/Samara
(316, 'RU', 'Russian Federation', 'Europe/Samara', 'UTC +04:00', 53.195877, 50.100202),

-- 317) RU / Europe/Saratov
(317, 'RU', 'Russian Federation', 'Europe/Saratov', 'UTC +04:00', 51.533557, 46.034257),

-- 318) RU / Europe/Ulyanovsk
(318, 'RU', 'Russian Federation', 'Europe/Ulyanovsk', 'UTC +04:00', 54.314192, 48.403123),

-- 319) RU / Europe/Volgograd
(319, 'RU', 'Russian Federation', 'Europe/Volgograd', 'UTC +03:00', 48.708047, 44.513303),

-- 320) RW / Africa/Kigali
(320, 'RW', 'Rwanda', 'Africa/Kigali', 'UTC +02:00', -1.957875, 30.112735),

-- 321) RE / Indian/Reunion
(321, 'RE', 'Réunion', 'Indian/Reunion', 'UTC +04:00', -21.115141, 55.536384),

-- 322) BL / America/St_Barthelemy
(322, 'BL', 'Saint Barthélemy', 'America/St_Barthelemy', 'UTC -04:00', 17.900000, -62.833333),

-- 323) SH / Atlantic/St_Helena
(323, 'SH', 'Saint Helena, Ascension and Tristan da Cunha', 'Atlantic/St_Helena', 'UTC', -15.965929, -5.708183),

-- 324) KN / America/St_Kitts
(324, 'KN', 'Saint Kitts and Nevis', 'America/St_Kitts', 'UTC -04:00', 17.357822, -62.782998),

-- 325) LC / America/St_Lucia
(325, 'LC', 'Saint Lucia', 'America/St_Lucia', 'UTC -04:00', 13.909444, -60.978893),

-- 326) MF / America/Marigot
(326, 'MF', 'Saint Martin (French part)', 'America/Marigot', 'UTC -04:00', 18.066667, -63.083333),

-- 327) PM / America/Miquelon
(327, 'PM', 'Saint Pierre and Miquelon', 'America/Miquelon', 'UTC -03:00', 46.775846, -56.195027),

-- 328) VC / America/St_Vincent
(328, 'VC', 'Saint Vincent and the Grenadines', 'America/St_Vincent', 'UTC -04:00', 13.156767, -61.225906),

-- 329) WS / Pacific/Apia
(329, 'WS', 'Samoa', 'Pacific/Apia', 'UTC +13:00', -13.833333, -171.750000),

-- 330) SM / Europe/San_Marino
(330, 'SM', 'San Marino', 'Europe/San_Marino', 'UTC +01:00', 43.932156, 12.448630),

-- 331) ST / Africa/Sao_Tome
(331, 'ST', 'Sao Tome and Principe', 'Africa/Sao_Tome', 'UTC', 0.186360, 6.613081),

-- 332) SA / Asia/Riyadh
(332, 'SA', 'Saudi Arabia', 'Asia/Riyadh', 'UTC +03:00', 24.713552, 46.675296),

-- 333) SN / Africa/Dakar
(333, 'SN', 'Senegal', 'Africa/Dakar', 'UTC', 14.716677, -17.467686),

-- 334) RS / Europe/Belgrade
(334, 'RS', 'Serbia', 'Europe/Belgrade', 'UTC +01:00', 44.786568, 20.448921),

-- 335) SC / Indian/Mahe
(335, 'SC', 'Seychelles', 'Indian/Mahe', 'UTC +04:00', -4.679574, 55.491977),

-- 336) SL / Africa/Freetown
(336, 'SL', 'Sierra Leone', 'Africa/Freetown', 'UTC', 8.465677, -13.231722),

-- 337) SG / Asia/Singapore
(337, 'SG', 'Singapore', 'Asia/Singapore', 'UTC +08:00', 1.352083, 103.819836),

-- 338) SX / America/Lower_Princes
(338, 'SX', 'Sint Maarten (Dutch part)', 'America/Lower_Princes', 'UTC -04:00', 18.042480, -63.054830),

-- 339) SK / Europe/Bratislava
(339, 'SK', 'Slovakia', 'Europe/Bratislava', 'UTC +01:00', 48.148596, 17.107748),

-- 340) SI / Europe/Ljubljana
(340, 'SI', 'Slovenia', 'Europe/Ljubljana', 'UTC +01:00', 46.056947, 14.505751),

-- 341) SB / Pacific/Guadalcanal
(341, 'SB', 'Solomon Islands', 'Pacific/Guadalcanal', 'UTC +11:00', -9.645710, 160.156194),

-- 342) SO / Africa/Mogadishu
(342, 'SO', 'Somalia', 'Africa/Mogadishu', 'UTC +03:00', 2.046934, 45.318162),

-- 343) ZA / Africa/Johannesburg
(343, 'ZA', 'South Africa', 'Africa/Johannesburg', 'UTC +02:00', -26.204103, 28.047305),

-- 344) GS / Atlantic/South_Georgia
(344, 'GS', 'South Georgia and the South Sandwich Islands', 'Atlantic/South_Georgia', 'UTC -02:00', -54.429579, -36.587909),

-- 345) SS / Africa/Juba
(345, 'SS', 'South Sudan', 'Africa/Juba', 'UTC +02:00', 4.851650, 31.582470),

-- 346) ES / Africa/Ceuta
(346, 'ES', 'Spain', 'Africa/Ceuta', 'UTC +01:00', 35.889387, -5.319786),

-- 347) ES / Atlantic/Canary
(347, 'ES', 'Spain', 'Atlantic/Canary', 'UTC', 28.291565, -16.629129),

-- 348) ES / Europe/Madrid
(348, 'ES', 'Spain', 'Europe/Madrid', 'UTC +01:00', 40.416775, -3.703790),

-- 349) LK / Asia/Colombo
(349, 'LK', 'Sri Lanka', 'Asia/Colombo', 'UTC +05:30', 6.927079, 79.861244),

-- 350) SD / Africa/Khartoum
(350, 'SD', 'Sudan', 'Africa/Khartoum', 'UTC +02:00', 15.500654, 32.559899),

-- 351) SR / America/Paramaribo
(351, 'SR', 'Suriname', 'America/Paramaribo', 'UTC -03:00', 5.852036, -55.203828),

-- 352) SJ / Arctic/Longyearbyen
(352, 'SJ', 'Svalbard and Jan Mayen', 'Arctic/Longyearbyen', 'UTC +01:00', 78.223172, 15.626723),

-- 353) SZ / Africa/Mbabane
(353, 'SZ', 'Swaziland', 'Africa/Mbabane', 'UTC +02:00', -26.305448, 31.136672),

-- 354) SE / Europe/Stockholm
(354, 'SE', 'Sweden', 'Europe/Stockholm', 'UTC +01:00', 59.329323, 18.068581),

-- 355) CH / Europe/Zurich
(355, 'CH', 'Switzerland', 'Europe/Zurich', 'UTC +01:00', 47.376887, 8.541694),

-- 356) SY / Asia/Damascus
(356, 'SY', 'Syrian Arab Republic', 'Asia/Damascus', 'UTC +03:00', 33.513807, 36.276528),

-- 357) TW / Asia/Taipei
(357, 'TW', 'Taiwan, Province of China', 'Asia/Taipei', 'UTC +08:00', 25.032969, 121.565418),

-- 358) TJ / Asia/Dushanbe
(358, 'TJ', 'Tajikistan', 'Asia/Dushanbe', 'UTC +05:00', 38.559772, 68.787038),

-- 359) TZ / Africa/Dar_es_Salaam
(359, 'TZ', 'Tanzania, United Republic of', 'Africa/Dar_es_Salaam', 'UTC +03:00', -6.792354, 39.208328),

-- 360) TH / Asia/Bangkok
(360, 'TH', 'Thailand', 'Asia/Bangkok', 'UTC +07:00', 13.756331, 100.501762),

-- 361) TL / Asia/Dili
(361, 'TL', 'Timor-Leste', 'Asia/Dili', 'UTC +09:00', -8.556855, 125.560314),

-- 362) TG / Africa/Lome
(362, 'TG', 'Togo', 'Africa/Lome', 'UTC', 6.131945, 1.222773),

-- 363) TK / Pacific/Fakaofo
(363, 'TK', 'Tokelau', 'Pacific/Fakaofo', 'UTC +13:00', -9.380000, -171.246667),

-- 364) TO / Pacific/Tongatapu
(364, 'TO', 'Tonga', 'Pacific/Tongatapu', 'UTC +13:00', -21.178986, -175.198242),

-- 365) TT / America/Port_of_Spain
(365, 'TT', 'Trinidad and Tobago', 'America/Port_of_Spain', 'UTC -04:00', 10.661339, -61.501925),

-- 366) TN / Africa/Tunis
(366, 'TN', 'Tunisia', 'Africa/Tunis', 'UTC +01:00', 36.806389, 10.181667),

-- 367) TR / Europe/Istanbul
(367, 'TR', 'Turkey', 'Europe/Istanbul', 'UTC +03:00', 41.008238, 28.978359),

-- 368) TM / Asia/Ashgabat
(368, 'TM', 'Turkmenistan', 'Asia/Ashgabat', 'UTC +05:00', 37.960077, 58.326063),

-- 369) TC / America/Grand_Turk
(369, 'TC', 'Turks and Caicos Islands', 'America/Grand_Turk', 'UTC -05:00', 21.466667, -71.133333),

-- 370) TV / Pacific/Funafuti
(370, 'TV', 'Tuvalu', 'Pacific/Funafuti', 'UTC +12:00', -8.516667, 179.216667),

-- 371) UG / Africa/Kampala
(371, 'UG', 'Uganda', 'Africa/Kampala', 'UTC +03:00', 0.347596, 32.582520),

-- 372) UA / Europe/Kyiv
(372, 'UA', 'Ukraine', 'Europe/Kyiv', 'UTC +02:00', 50.450100, 30.523400),

-- 373) UA / Europe/Simferopol
(373, 'UA', 'Ukraine', 'Europe/Simferopol', 'UTC +03:00', 44.948237, 34.100318),

-- 374) AE / Asia/Dubai
(374, 'AE', 'United Arab Emirates', 'Asia/Dubai', 'UTC +04:00', 25.204849, 55.270783),

-- 375) GB / Europe/London
(375, 'GB', 'United Kingdom', 'Europe/London', 'UTC', 51.507351, -0.127758),

-- 376) US / America/Adak
(376, 'US', 'United States', 'America/Adak', 'UTC -10:00', 51.883333, -176.633333),

-- 377) US / America/Anchorage
(377, 'US', 'United States', 'America/Anchorage', 'UTC -09:00', 61.218056, -149.900278),

-- 378) US / America/Boise
(378, 'US', 'United States', 'America/Boise', 'UTC -07:00', 43.615019, -116.202316),

-- 379) US / America/Chicago
(379, 'US', 'United States', 'America/Chicago', 'UTC -06:00', 41.878114, -87.629798),

-- 380) US / America/Denver
(380, 'US', 'United States', 'America/Denver', 'UTC -07:00', 39.739236, -104.990251),

-- 381) US / America/Detroit
(381, 'US', 'United States', 'America/Detroit', 'UTC -05:00', 42.331427, -83.045754),

-- 382) US / America/Indiana/Indianapolis
(382, 'US', 'United States', 'America/Indiana/Indianapolis', 'UTC -05:00', 39.768403, -86.158068),

-- 383) US / America/Indiana/Knox
(383, 'US', 'United States', 'America/Indiana/Knox', 'UTC -06:00', 41.295869, -86.625009),

-- 384) US / America/Indiana/Marengo
(384, 'US', 'United States', 'America/Indiana/Marengo', 'UTC -05:00', 38.374790, -86.344147),

-- 385) US / America/Indiana/Petersburg
(385, 'US', 'United States', 'America/Indiana/Petersburg', 'UTC -05:00', 38.491436, -87.278056),

-- 386) US / America/Indiana/Tell_City
(386, 'US', 'United States', 'America/Indiana/Tell_City', 'UTC -06:00', 37.951444, -86.761108),

-- 387) US / America/Indiana/Vevay
(387, 'US', 'United States', 'America/Indiana/Vevay', 'UTC -05:00', 38.747560, -85.067739),

-- 388) US / America/Indiana/Vincennes
(388, 'US', 'United States', 'America/Indiana/Vincennes', 'UTC -05:00', 38.677269, -87.528633),

-- 389) US / America/Indiana/Winamac
(389, 'US', 'United States', 'America/Indiana/Winamac', 'UTC -05:00', 41.051980, -86.603624),

-- 390) US / America/Juneau
(390, 'US', 'United States', 'America/Juneau', 'UTC -09:00', 58.301598, -134.419734),

-- 391) US / America/Kentucky/Louisville
(391, 'US', 'United States', 'America/Kentucky/Louisville', 'UTC -05:00', 38.252665, -85.758456),

-- 392) US / America/Kentucky/Monticello
(392, 'US', 'United States', 'America/Kentucky/Monticello', 'UTC -05:00', 36.829518, -84.850224),

-- 393) US / America/Los_Angeles
(393, 'US', 'United States', 'America/Los_Angeles', 'UTC -08:00', 34.052234, -118.243685),

-- 394) US / America/Menominee
(394, 'US', 'United States', 'America/Menominee', 'UTC -06:00', 45.107466, -87.614084),

-- 395) US / America/Metlakatla
(395, 'US', 'United States', 'America/Metlakatla', 'UTC -09:00', 55.126944, -131.574722),

-- 396) US / America/New_York
(396, 'US', 'United States', 'America/New_York', 'UTC -05:00', 40.712776, -74.005974),

-- 397) US / America/Nome
(397, 'US', 'United States', 'America/Nome', 'UTC -09:00', 64.501111, -165.406389),

-- 398) US / America/North_Dakota/Beulah
(398, 'US', 'United States', 'America/North_Dakota/Beulah', 'UTC -06:00', 47.264183, -101.777399),

-- 399) US / America/North_Dakota/Center
(399, 'US', 'United States', 'America/North_Dakota/Center', 'UTC -06:00', 47.116667, -101.300000),

-- 400) US / America/North_Dakota/New_Salem
(400, 'US', 'United States', 'America/North_Dakota/New_Salem', 'UTC -06:00', 46.843611, -101.410556),

-- 401) US / America/Phoenix
(401, 'US', 'United States', 'America/Phoenix', 'UTC -07:00', 33.448377, -112.074037),

-- 402) US / America/Sitka
(402, 'US', 'United States', 'America/Sitka', 'UTC -09:00', 57.053055, -135.330000),

-- 403) US / America/Yakutat
(403, 'US', 'United States', 'America/Yakutat', 'UTC -09:00', 59.548056, -139.727222),

-- 404) US / Pacific/Honolulu
(404, 'US', 'United States', 'Pacific/Honolulu', 'UTC -10:00', 21.306944, -157.858333),

-- 405) UM / Pacific/Midway
(405, 'UM', 'United States Minor Outlying Islands', 'Pacific/Midway', 'UTC -11:00', 28.213497, -177.365856),

-- 406) UM / Pacific/Wake
(406, 'UM', 'United States Minor Outlying Islands', 'Pacific/Wake', 'UTC +12:00', 19.283300, 166.616700),

-- 407) UY / America/Montevideo
(407, 'UY', 'Uruguay', 'America/Montevideo', 'UTC -03:00', -34.901113, -56.164531),

-- 408) UZ / Asia/Samarkand
(408, 'UZ', 'Uzbekistan', 'Asia/Samarkand', 'UTC +05:00', 39.655136, 66.959730),

-- 409) UZ / Asia/Tashkent
(409, 'UZ', 'Uzbekistan', 'Asia/Tashkent', 'UTC +05:00', 41.299496, 69.240073),

-- 410) VU / Pacific/Efate
(410, 'VU', 'Vanuatu', 'Pacific/Efate', 'UTC +11:00', -17.733251, 168.327325),

-- 411) VE / America/Caracas
(411, 'VE', 'Venezuela, Bolivarian Republic of', 'America/Caracas', 'UTC -04:00', 10.480594, -66.903606),

-- 412) VN / Viet Nam
(412, 'VN', 'Viet Nam', 'Asia/Ho_Chi_Minh', 'UTC +07:00', 10.823099, 106.629664),

-- 413) VG / Virgin Islands, British
(413, 'VG', 'Virgin Islands, British', 'America/Tortola', 'UTC -04:00', 18.420695, -64.639968),

-- 414) VI / Virgin Islands, U.S.
(414, 'VI', 'Virgin Islands, U.S.', 'America/St_Thomas', 'UTC -04:00', 18.338096, -64.894094),

-- 415) WF / Wallis and Futuna
(415, 'WF', 'Wallis and Futuna', 'Pacific/Wallis', 'UTC +12:00', -13.282509, -176.200433),

-- 416) YE / Yemen
(416, 'YE', 'Yemen', 'Asia/Aden', 'UTC +03:00', 12.784444, 45.018654),

-- 417) ZM / Zambia
(417, 'ZM', 'Zambia', 'Africa/Lusaka', 'UTC +02:00', -15.387526, 28.322817),

-- 418) ZW / Zimbabwe
(418, 'ZW', 'Zimbabwe', 'Africa/Harare', 'UTC +02:00', -17.825166, 31.033510),

-- 419) AX / Åland Islands
(419, 'AX', 'Åland Islands', 'Europe/Mariehamn', 'UTC +02:00', 60.097264, 19.934835);

/*********************************************************
  Ajuste final del AUTO_INCREMENT (si procede) y COMMIT
**********************************************************/
ALTER TABLE `app_time_zone_coords`
  MODIFY `id` INT(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=420;

COMMIT;