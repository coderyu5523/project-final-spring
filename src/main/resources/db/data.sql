INSERT INTO user_tb(username, password, phone, name, birth, gender, height, user_img, total_coin, goal_muscle, goal_fat,
                    goal_weight, created_at)
VALUES ('ssar', '$2a$10$5Z2/Wx9Lc8jCDSOz9pd6FOSFa3rou4lkf9gzFFrSzddRibYJAafau', '010-0100-0100', '류재성', '1994-04-22',
        'M', 178.5, '/upload/86d1375a-9cc3-47bc-a1a0-6561c01fa2e4_saram1.png', 500, 35.0, 12.0, 70.0, now()),
       ('cos', '$2a$10$M119OnzkM1HHpZLCDIhrne4mYR9bwQWvRoHXvZMfh1Yxamf8UbmHq', '010-0022-0022', '하승진', '1994-12-26',
        'M', 169.8, '/upload/86d1375a-9cc3-47bc-a1a0-6561c01fa2e4_saram1.png', 500, 25.7, 15.0, 70.0, now()),
       ('love', '$2a$10$M119OnzkM1HHpZLCDIhrne4mYR9bwQWvRoHXvZMfh1Yxamf8UbmHq', '010-0033-0033', '김정수', '1996-08-13',
        'M', 172.3, '/upload/86d1375a-9cc3-47bc-a1a0-6561c01fa2e4_saram1.png', 500, 26.9, 22.3, 73.8, now()),
       ('egdg', '$2a$10$M119OnzkM1HHpZLCDIhrne4mYR9bwQWvRoHXvZMfh1Yxamf8UbmHq', '010-0044-0044', '장유진', '1994-03-06',
        'F', 163.7, '/upload/86d1375a-9cc3-47bc-a1a0-6561c01fa2e4_saram1.png', 500, 24.5, 21.4, 53.7, now()),
       ('hsj', '$2a$10$M119OnzkM1HHpZLCDIhrne4mYR9bwQWvRoHXvZMfh1Yxamf8UbmHq', '010-0055-0055', '공지영', '1996-10-08',
        'F', 167.2, '/upload/86d1375a-9cc3-47bc-a1a0-6561c01fa2e4_saram1.png', 500, 23.4, 20.5, 55.2, now())
--        ('love', '1234', '010-0033-0033', '홍길동', '1997-04-02', 'M', 173.4, null, 500, 30.0, 18.0, now());
;

INSERT INTO activity_tb(user_id, walking, drink_water, created_at)
VALUES (1, 5325, 2000, '2024-05-16'),
       (1, 7028, 2300, '2024-05-17'),
       (1, 10000, 2000, '2024-05-18'),
       (1, 10000, 2500, '2024-05-19'),
       (1, 10000, 2000, '2024-05-20'),
--        (1, 7028, 2300, '2024-05-21'),
--        (1, 8303, 2500, '2024-05-22'),
       (2, 3081, 1800, '2024-05-20'),
       (2, 4232, 2000, '2024-05-21'),
       (2, 5532, 2300, '2024-05-22'),
       (3, 5308, 1800, '2024-05-20'),
       (3, 9051, 2000, '2024-05-21'),
       (3, 9180, 2300, '2024-05-22'),
       (4, 7150, 1800, '2024-05-20'),
       (4, 6084, 2000, '2024-05-21'),
       (4, 5094, 2300, '2024-05-22'),
       (5, 10000, 1800, '2024-05-20'),
       (5, 9208, 2000, '2024-05-21'),
       (5, 6188, 2300, '2024-05-22');

INSERT INTO bodydata_tb(user_id, weight, muscle, fat, created_at)
VALUES (1, 76.3, 21.5, 21.3, '2024-05-16 18:12'),
       (1, 76.3, 21.5, 21.3, '2024-05-17 18:12'),
       (1, 75.8, 21.5, 21.3, '2024-05-18 19:32'),
       (1, 76.3, 21.5, 21.3, '2024-05-19 18:12'),
       (1, 76.3, 21.5, 21.3, '2024-05-20 18:12'),
       (2, 76.3, 21.5, 21.3, '2024-05-16 18:12'),
       (2, 76.3, 21.5, 21.3, '2024-05-17 18:12'),
       (2, 75.8, 21.5, 21.3, '2024-05-18 19:32'),
       (2, 76.3, 21.5, 21.3, '2024-05-19 18:12'),
       (2, 76.3, 21.5, 21.3, '2024-05-20 18:15'),
       (3, 76.3, 21.5, 21.3, '2024-05-16 18:12'),
       (3, 76.3, 21.5, 21.3, '2024-05-17 18:12'),
       (3, 75.8, 21.5, 21.3, '2024-05-18 19:32'),
       (3, 76.3, 21.5, 21.3, '2024-05-19 18:12'),
       (3, 76.3, 21.5, 21.3, '2024-05-20 18:15'),
       (4, 76.3, 21.5, 21.3, '2024-05-16 18:12'),
       (4, 76.3, 21.5, 21.3, '2024-05-17 18:12'),
       (4, 75.8, 21.5, 21.3, '2024-05-18 19:32'),
       (4, 76.3, 21.5, 21.3, '2024-05-19 18:12'),
       (4, 76.3, 21.5, 21.3, '2024-05-20 18:15'),
       (5, 76.3, 21.5, 21.3, '2024-05-16 18:12'),
       (5, 76.3, 21.5, 21.3, '2024-05-17 18:12'),
       (5, 75.8, 21.5, 21.3, '2024-05-18 19:32'),
       (5, 76.3, 21.5, 21.3, '2024-05-19 18:12'),
       (5, 76.3, 21.5, 21.3, '2024-05-20 18:15');

insert into challenge_tb(challenge_name, background_img, sub_title, walking, badge_img, content, coin, period, distance,
                         created_at)
values ('에베레스트', '/upload/abf1c607-62c7-429d-9601-6edb1a3e4965_everest.png', '히말라야-네팔 8848.0m(약 2.7천층 올라감)', 350000,
        '/upload/abf1c607-62c7-429d-9601-6edb1a3e4965_everest.png',
        '세계에서 가장 높은 산을 오르세요! 해발 고도 8,848m(29029피트)에 있는 에베레스트산은 가장 상징적이고 도전적인 탐험지 중 하나로, 산봉우리의 험난한 조건과 높은 고도 뿐 아니라 험준하고 가파른 지형을 견디는 산악인들의 신체적, 정신적 한계를 시험하고 있습니다. 네팔과 티베트 사이의 국경에 자리하고 있으며 많은 현지인들에게 성스러운 문화재이자 신성한 장소입니다.',
        2, 30, '8848m', now()),
       ('에베레스트 베이스캠프 트레킹', '/upload/ab9dde60-6ce4-41f9-a848-aced82c5d38c_basecampEV.png', '히말라야-네팔 62.0km(약 8.7만개의 계단)', 300000,
        '/upload/ab9dde60-6ce4-41f9-a848-aced82c5d38c_basecampEV.png',
        '세계에서 가장 상징적인 트레킹 중 하나인 에베레스트 베이스캠프 루트를 정복하세요. 네팔의 히말라야를 거쳐 세계에서 가장 높은 산인 에베레스트산의 베이스캠프로 이동합니다. 이 탐험은 작은 마을인 루클라(Lukla)에서 시작하여 셰르파 마을인 남체 바자(Namche Bazaar), 텅보체(Tengboche), 딩보체(Dingboche), 고락셉(Gorakshep)을 통과합니다. 하이커들은 강과 고지대 통행로를 지나는 것과 더불어 풍부한 문화, 종교, 환대로 유명한 솔루쿰부(Solukhumbu) 지구의 중심부를 거쳐 이동합니다.',
        2, 30, '6200m', now()),
       ('칠쿠트 트레일', '/upload/270f40f2-683f-4a9a-be40-764e377847c6_chilkoot.png', '코스트산맥-알래스카 및 캐나다 53.0km(약 7.4만개의 계단)', 10000,
        '/upload/270f40f2-683f-4a9a-be40-764e377847c6_chilkoot.png',
        '칠쿠트 트레일은 브리티시컬럼비아 해안 우림, 그리고 알래스카의 고산 지대 초원과 빙하를 거치며 구불구불 나 있는 유서 깊고 경치 좋은 하이킹 트레일입니다. 이 트레일은 과거에 그 지역의 원주민들이 사용했으며, 19세기 후반에는 클론다이크 골드러시 시기에 금광을 찾는 이들에게 인기 루트가 되었습니다. 길을 따라가면 골드러시 시기와 관련된 오두막, 준설기, 금을 찾으러 몰려든 사람들의 야영지 등 유적지와 유물을 보실 수 있습니다.',
        2, 30, '53K', now()),
       ('엘브루스', '/upload/84388465-4372-4822-b458-60844aec5a8c_elbrus.png', '코카서스산맥-러시아 5642.0m(약 1.7천층 올라감)', 200000,
        '/upload/84388465-4372-4822-b458-60844aec5a8c_elbrus.png',
        '엘브루스산은 마지막으로 서기 50년에 폭발한 휴화산이며, 일곱 개의 정상 중 하나입니다. 이는 유럽에서 가장 높은 산으로, 조지아 국경 근처 러시아 남부에 위치하고 있습니다. 이 산에는 두개의 산봉우리가 있고, 옛 분화구는 지금은 눈과 얼음으로 가득하여, 5,620여 미터(18,440여 피트) 솟아올라 있습니다. 로마인들은 엘브루스를 ''스트로빌루스'' 라고 했는데 이는 라틴어로 ''솔방울''을 의미하며 산의 뒤틀린 모양을 본뜬 것입니다.',
        2, 30, '5642m', now()),
       ('그랜드 캐니언 림 트레일', '/upload/df7233de-0da2-42ad-8852-33386b756e9a_grandcanyon.png', '콜로라도고원-미국 21.0km(약 3만개의 계단)', 150000,
        '/upload/df7233de-0da2-42ad-8852-33386b756e9a_grandcanyon.png',
        '이 탐험은 헤르미츠 레스트와 동쪽의 사우스 카이밥 트레일헤드 사이에 있는 애리조나주 그랜드 캐니언 국립 공원의 사우스 림을 따라 운영됩니다. 다양한 목적에 따라 이용할 수 있는 이곳은 약 21km(13마일) 길이의 포장된 트레일이며 브라이트 에인절 캐니언(Bright Angel Canyon)과 콜로라도 강 등 세계에서 가장 상징적인 자연의 경이로움 중 하나인 절경이 펼쳐집니다.',
        2, 30, '21K', now()),
       ('산티아고 순례길', '/upload/b97ca653-62da-47ce-9807-a4a882185a71_santiago.png', '피레네-프랑스 및 스페인 784.0km(약 110만개의 계단)', 200000,
        '/upload/b97ca653-62da-47ce-9807-a4a882185a71_santiago.png',
        '수 세기 동안, 사람들은 이 여정을 영적, 육체적 성취를 이룰 수 있는 하나의 방법으로 만들어 왔습니다. 산티아고 순례길은 세인트 제임스의 길로도 알려져 있으며, 유럽 전역에 걸쳐 뻗어 있고 스페인 북서부의 산티아고 순례길에 있는 사도 세인트 제임스의 성지에서 모입니다. 이 탐험은 ''프랑스 길(Camino Frances)''을 따라가며, 프랑스 길은 St.Jean Pied de Port에서 시작되어, 스페인 북부에 걸쳐 거의 800킬로미터(500마일)을 뻗어 나갑니다.',
        2, 30, '784K', now()),
       ('디날리', '/upload/2002831a-b5cd-4e4d-8527-2e0a53e6c7f4_denali.png', '알래스카산맥-미국 6190.0m(약 1.9천층 올라감)', 10000,
        '/upload/2002831a-b5cd-4e4d-8527-2e0a53e6c7f4_denali.png',
        '맥킨리산으로도 알려진 디날리는 북미에서 가장 높은 산봉우리 7개 중 하나이자 최고봉이며, 해발 6,191미터(20,310피트)입니다. 이 클라이밍은 산악인들의 수요가 높은 탐험으로 매년 1,200여 명이 정상 정복을 시도하고 있습니다. 디날리는 극심한 기상 조건과 까다로운 지형으로 유명합니다. 이 산은 알래스카의 야생 지대 6백만여 에이커를 아우르는 디날리 국립 공원 및 자연 보호 구역에 위치하고 있습니다.',
        2, 30, '6190m', now()),
       ('잉카 트레일', '/upload/80f907a7-b709-4f9b-8c43-bde12b726606_inca.png', '안데스-페루 40.0km(약 5.6만개의 계단)', 150000,
        '/upload/80f907a7-b709-4f9b-8c43-bde12b726606_inca.png',
        '이 유서깊은 40km(25마일) 트레일은 페루의 안데스산맥 사이로 구불구불 나 있으며, 마추픽추로 가는 철도를 타고 82km 지점에서 시작하여 여러 고산 지대 산길과 우거진 숲들을 가로지릅니다. 트레일을 따라, 하이커들은 험준한 산악 환경에서 살아남기 위해 제적된 석벽, 테라스, 수로 등 다수의 잉카 유적 및 고대 유적지들을 마주칩니다.',
        2, 30, '40K', now()),
       ('K2', '/upload/dc29a51b-435c-41d2-a145-ecbba2157798_k2.png', '카라코람산맥-파키스탄 8,611m(약 2.6천층 올라감)', 310000,
        '/upload/dc29a51b-435c-41d2-a145-ecbba2157798_k2.png',
        '히말라야 카라코람산맥의 파키스탄과 중국 국경에 위치한 K2는 세계에서 두 번째로 높은 산으로, 해발 8,611미터(28,251 피트)에 달합니다. 이 클라이밍은 가파르고 위험한 지형으로 유명하며, 예측할 수 없는 기상 조건으로 인해 산악인들이 정상에 도달하기 어렵습니다. 덕분에 K2는 ''살벌한 산(Savage Mountain)''이라는 별명을 얻었습니다.',
        2, 30, '8611m', now()),
       ('킬리만자로', '/upload/83912acc-ab15-490c-97f5-da3b0f803ac4_kili.png', '이스턴리프트산맥-탄자니아 5,895.0m(약 1.8천층 올라감)', 200000,
        '/upload/83912acc-ab15-490c-97f5-da3b0f803ac4_kili.png',
        '킬리만자로는 탄자니아의 휴화산이며 아프리카에서 최고봉으로, 해발 고도 5,895미터(19,341 피트)에 달합니다. 이 클라이밍은 여러 기후대를 거쳐 이동하면서, 산기슭의 무성한 열대우림에서 시작해 고산 지대 초원과 메마른 고지대 사막을 거쳐 나아간 후 정상에 도달합니다..',
        2, 30, '5895m', now()),
       ('웨스트 하일랜드 웨이', '/upload/b0129dec-aef8-4dba-91a5-2c02350f9b53_west.png', '하일랜드-스코틀랜드 154.0km(약 22만개의 계단)', 100000,
        '/upload/b0129dec-aef8-4dba-91a5-2c02350f9b53_west.png',
        '웨스트 하일랜드 웨이 도로를 타고 스코틀랜드 전역에서 154킬로미터(96마일)를 이동합니다. 이 인기 루트는 글래스고 인근 밀른게이브(Milngavie)에서 출발해 스코틀랜드 하일랜드에 있는 포트 윌리엄까지 이어지며, 라녹 무어, 글렌코, 악마의 계단 등 스코틀랜드 외딴 야생 지역 중 가장 아름다운 몇몇 곳을 통과합니다..',
        2, 30, '154K', now()),
       ('빈슨', '/upload/4479eb56-7509-4041-b725-70617ccdd6a8_vinson.png', '엘즈워스산맥-남극대륙 4,892.0m(약 1.5천층 올라감)', 150000,
        '/upload/4479eb56-7509-4041-b725-70617ccdd6a8_vinson.png',
        '엘즈워스산맥의 센티널 산맥에 위치한 빈슨 산괴(Vinson Massif)는 빈슨산으로도 알려져 있습니다. 남극 대륙에서 가장 높은 산으로 4,892미터(16,050피트)에 달합니다. 이 클라이밍은 빙벽 등반, 빙하를 통한 이동, 가파른 산악 스키가 조합되어 있습니다. 빈슨산은 외딴 위치, 난이도, 혹독한 날씨 조건으로 산악인과 모험 애호가들의 수요가 높은 클라이밍입니다.',
        2, 30, '4892m', now()),
       ('라인슈타이크 트레일', '/upload/78cdac22-368a-4c32-a449-45b955243684_rhein.png', '라인강-독일 320.0km(약 45만개의 계단)', 120000,
        '/upload/78cdac22-368a-4c32-a449-45b955243684_rhein.png',
        '라인슈타이크 트레일은 독일 중부의 라인강을 따라 운영되며, 헤센주의 비스바덴에서 북부 노르트라인베스트팔렌주의 본까지 뻗어 있습니다. 라인협곡과 타우누스산맥의 가장 아름다운 풍경은 물론 유서 깊은 소도시와 마을들도 지나갑니다. 이 트레킹은 경험이 풍부한 하이커들과 비교적 여유롭게 문화 및 역사적 모험을 찾는 이들을 끌어들입니다.',
        2, 30, '320K', now()),
       ('안나푸르나 서킷', '/upload/972cc76d-7c10-45d6-85d3-bed3025164d4_anna.png', '히말라야-네팔 260.1km(약 36만개의 계단)', 150000,
        '/upload/972cc76d-7c10-45d6-85d3-bed3025164d4_anna.png',
        '안나푸르나 서킷은 네팔의 안나푸르나 산맥을 거쳐 이동하며, 소도시 베시사하르에서 시작하여 마르샹디강을 따라 차메 마을에 이른 후 점차 더 높은 산 속으로 오릅니다. 이 탐험은 작은 마을과 찻집들뿐 아니라 가는 길에 숲, 강, 폭포, 고지대 통행로들도 거치면서 지나갑니다. 해발 5,416미터(17,769피트)로 세상에서 가장 높은 산길 중 하나인 토롱 라 패스(Thorong La Pass)가 이 루트의 하이라이트 중 하나입니다.',
        2, 30, '260K', now()),
       ('아콩가과', '/upload/b45f3bb4-c587-4e11-9c42-2667db5f8615_acon.png', '안데스-아르헨티나 6,961.0m(약 2.1천층 올라감)', 220000,
        '/upload/b45f3bb4-c587-4e11-9c42-2667db5f8615_acon.png',
        '아콩카과산은 서반구와 남반구에서 가장 높은 지점이며, 해발 6,961미터(22,837피트)로 안데스산맥의 주산맥(Principal Cordillera)에 위치해 있습니다. 아콩가과라는 명칭은 ''바위 파수꾼(Stone Sentinel)''을 의미하는 케추아어에서 유래한 것으로, 이 산의 독특한 암석 분포에 기인합니다. 그 산봉우리는 화강암, 안산암, 현무암 등 다양한 암석 유형들로 구성되어 있으며, 여러 개의 빙하가 있습니다.',
        2, 30, '6961m', now()),
       ('만리장성', '/upload/0cc70a86-8dd8-436e-9065-f6efae8fe3c8_manri.png',
        '지엔커우 만리장성(기점 Xizhazi Village)-중국 20.0km(약 2.8만개의 계단)', 120000,
        '/upload/0cc70a86-8dd8-436e-9065-f6efae8fe3c8_manri.png',
        '만리장성 하이킹은 세계에서 가장 위대한 고대 건축물의 경이로움 중 하나를 따라 이동하면서, 가는 길에 감시탑과 흉벽을 지나갑니다. 이 탐험에는 무티엔위와 모시커우 구역 사이에 위치한 중국 만리장성의 지엔커우 구간이 포함됩니다. 우리가 오늘날 보는 현 만리장성의 대부분은 명나라(1368~1644) 때 세워졌으며 약 6,000킬로미터에 달합니다.',
        2, 30, '20K', now()),
       ('크레이들산 오버랜드 트랙', '/upload/a26efa14-434a-48a0-a405-65931949f69a_cradle.png', '태즈메이니아-호주 65.0km(약 9.1만개의 계단)', 160000,
        '/upload/a26efa14-434a-48a0-a405-65931949f69a_cradle.png',
        '호주 최고의 고산 지대 걷기 코스인 태즈메이니아의 크레이들산 오버랜드 트랙을 하이킹하세요. 이 탐험은 로니크릭(Ronny Creek)에서 시작해 65킬로미터(40.4마일)를 이동하여 세인트클레어호로 향하면서, 울창한 숲에서 안개가 자욱한 계곡까지 다양한 풍경을 지나갑니다. 또한 하이커들이 태즈메이니아 고원의 경치를 감상할 수 있는 크레이들 마운틴-세인트클레어호 국립 공원의 황야도 포함됩니다.',
        2, 30, '65K', now()),
       ('애팔래치안 트레일', '/upload/9b3f2c98-15c7-4e96-888e-34d26db82161_appalachian.png', '애팔래치아산맥-미국 3,500.0km(약 490만개의 계단)',
        230000, '/upload/9b3f2c98-15c7-4e96-888e-34d26db82161_appalachian.png',
        '애팔래치아 트레일을 타고 미국 동부를 탐험하세요. 이 등산로는 애팔래치아산맥을 따라 조지아주 스프링어산부터 메인주 카타딘산까지 약 35500km(2,175마일) 뻗어 있습니다. 이 탐험은 숲, 언덕, 바위투성이 산등성이부터 강과 개울을 가로지르는 다양한 지형을 지나면서 이동합니다. 이 트레일은 또한 수많은 소도시와 마을을 통과하며, 하이커들은 이곳에서 음식 및 기타 필수품을 다시 채웁니다.',
        2, 30, '3500K', now()),
       ('코지어스코', '/upload/0542e017-d21f-40c9-b197-63278fdc6a2a_koscius.png', '스노이산맥-호주 2,228.0m(약 675층 올라감)', 180000,
        '/upload/0542e017-d21f-40c9-b197-63278fdc6a2a_koscius.png',
        '뉴사우스웨일스주의 스노이산맥에 위치한 코지어스코산은 호주 본토에서 가장 높은 산으로 해발 고도 2,228미터(7,310피트)에 달합니다. 클라이밍이 상대적으로 쉽게 여겨지는데, 표시가 잘 되어 있고 점진적으로 정상에 오르기 때문입니다. 이 산은 고산 지형, 멋진 경관, 다양한 동식물로 유명한 코지어스코 국립 공원의 일부입니다.',
        2, 30, '2228m', now()),
       ('밀퍼드 트랙', '/upload/a5103fce-bafa-4877-a633-8a8d7d6b2fd2_milford.png', '남섬-뉴질랜드 53.0km(약 7.4만개의 계단)', 170000,
        '/upload/a5103fce-bafa-4877-a633-8a8d7d6b2fd2_milford.png',
        '밀퍼드 트랙 하이킹 이동 구간은 뉴질랜드 피오르드랜드 국립 공원의 우림 계곡과 장엄한 산속으로 깊숙이 이어집니다. 이 탐험은 테아나우호의 상류에서 시작해 클린턴강을 따라, 울창한 숲 사이를 구불구불 지난 후 웅장한 서덜랜드폭포에 도달해 매키넌 패스(McKinnon Pass)를 넘어 아서계곡의 고산 야생 지역을 오릅니다. 밀퍼드 트랙은 숨 막히는 경치와 접근성으로 세계 최고의 산책로 중 하나로 손꼽힙니다.',
        2, 30, '53K', now()),
       ('몽블랑', '/upload/c731cb2c-a2da-46f3-890b-95d9337f0179_montblanc.png', '알프스-프랑스 및 이탈리아 4,808.0m(약 1.5천층 올라감)', 230000,
        '/upload/c731cb2c-a2da-46f3-890b-95d9337f0179_montblanc.png',
        '몽블랑은 해발 4,808미터(15,774피트)에 달하는 유럽 알프스산맥의 최고봉인 몽블랑에 올라보세요. 이 표준 이동 구간은 샤모니몽블랑 근처의 레 우쉬(Les Houches)에서 시작되며 정상에 도달하기 위해 하이킹, 스크램블링, 고정 로프 및 사다리를 이용한 클라이밍의 조합이 포함됩니다. 이 클라이밍을 하는 동안 알프스와 주변 빙하 및 계곡들의 절경이 펼쳐집니다.',
        2, 30, '4808m', now()),
       ('몽블랑 서큘러', '/upload/573ca70b-4ca6-4009-9cf0-be5703ee9634_montcir.png', '알프스-프랑스, 이탈리아, 스위스 160.0km(약 22만개의 계단)', 180000,
        '/upload/573ca70b-4ca6-4009-9cf0-be5703ee9634_montcir.png',
        '몽블랑 서큘러 하이킹 루트는 알프스를 통과하며 이동하면서 유럽에서 최고봉 중 하나인 몽블랑 산괴를 둘러봅니다. 이 인기 트레일은 숲과 초원에서 빙하와 높은 산길까지 다양한 유형의 고산 지대 환경을 지나갑니다. 이 트레킹은 약 160km로, 일반적으로 하이커들이 완료하는 데 10~12일이 소요됩니다.',
        2, 30, '160K', now()),
       ('아라라트', '/upload/4f793c6b-3a3e-4802-89d5-f923a1f45ff7_ararat.png', '아르메니아고원-터키 5,137.0m(약 1.6천층 올라감)', 200000,
        '/upload/4f793c6b-3a3e-4802-89d5-f923a1f45ff7_ararat.png',
        '터키에서 최고봉인 아라라트산을 정복하세요. 아라라트산은 해발 고도 5,137미터(16,854피트)에 달합니다. 아라라트산은 아르메니아와 이란의 국경 근처인 터키 동부에 있는 휴화산입니다. 이 산은 노아의 방주가 묻혀있는 것으로 여겨져 중요한 문화적, 종교적 의미를 지닙니다. 이 클라이밍은 가파르고 들쭉날쭉한 산봉우리와 멋진 자연미로 유명합니다.',
        2, 30, '5137m', now()),
       ('킬리만자로 마차메 루트', '/upload/c3e6095d-966b-40b6-8d3a-c43df99d0e10_machame.png', '이스턴리프트산맥-탄자니아 62.0km(약 8.7만개의 계단)', 100000,
        '/upload/c3e6095d-966b-40b6-8d3a-c43df99d0e10_machame.png',
        '아프리카에서 최고봉인 해발 고도 5,895미터(19,341피트)에 달하는 탄자니아 킬리만자로산을 하이킹하세요. 이 탐험은 인기 루트인 마차메 루트를 따라 마차메 게이트에서 시작됩니다. 이 트레킹은 산 남쪽 기슭에 있는 울창한 열대우림과 광활한 시라고원을 거쳐, ''용암탑''으로 알려진 상징적인 화산전(volcanic plug)를 지나, 메마른 고지대 사막을 거쳐 이동한 후 정상에 도달합니다.',
        2, 30, '62K', now()),
       ('올림푸스', '/upload/282416ba-af4c-460c-93e1-33014e52838b_olympus.png', '올림푸스산맥-그리스 에비아섬 2,917.0m(약 885층 올라감)', 190000,
        '/upload/282416ba-af4c-460c-93e1-33014e52838b_olympus.png',
        '올림푸스산은 그리스 북부, 테살로니키라는 도시 근처에 있습니다. 이는 그리스에서 가장 높은 산으로, 그중 가장 큰 산봉우리인 미티카스는 해발 고도 2,917미터(9,570피트)에 달할 뿐만 아니라, 고대 그리스 종교와 신화에서 가장 중요한 산봉우리로 여겨지기도 합니다. 이는 제우스, 헤라, 아폴로, 아테나 등 12명의 올림피아 신들의 고향으로 믿어졌습니다. 이 클라이밍을 하다 보면 주변 산봉우리와 에게해의 절경이 펼쳐지며, 정상에서 작은 예배당을 발견하게 됩니다.',
        2, 30, '2917m', now()),
       ('투브칼 서킷', '/upload/e1288507-5bc8-4821-b6f7-4d23d75d7610_toubkal.png', '아틀라스산맥-모로코 60.0km(약 8.4만개의 계단)', 10000,
        '/upload/e1288507-5bc8-4821-b6f7-4d23d75d7610_toubkal.png',
        '모로코의 아틀라스 산맥에서 북아프리카 최고봉인 투브칼산을 하이킹하세요. 투브칼 서킷 탐험은 붐비는 시장이 서는 소도시인 임릴(Inlil)에서 시작됩니다. 바위투성이 지형과 무성한 초목을 거치고, 정상이 가까워지면서 맨 바위와 눈이 보이며 트레일이 마무리됩니다. 이 루트는 길을 따라 마을들을 지나기 때문에 하이커들이 베르베르족의 일상생활과 문화를 경험할 수 있습니다.',
        2, 30, '60K', now()),
       ('파타고니아 서킷', '/upload/51676235-202e-4f61-b9ce-f4e58ac5c229_patagonia.png', '안데스-파타고니아, 아르헨티나, 칠레 120.0km(약 17만개의 계단)',
        140000, '/upload/51676235-202e-4f61-b9ce-f4e58ac5c229_patagonia.png', '남미의 야생 자연, 파타고니아 서킷을 탐험하세요.', 2, 30, '120K',
        now()),
       ('그로스글로크너', '/upload/a79e04fc-31b8-4c5b-9729-fa1192dc7c76_grossglock.png', '알프스-오스트리아 3,798.0m(약 1.2천층 올라감)', 100000,
        '/upload/c6d37c1b-a37b-45a6-a170-5254a68970de_grossglock.png', '알프스 오스트리아에서 그로스글로크너를 탐험하세요.', 2, 30, '3798m', now());

insert into attend_challenge_tb(user_id, total_walking, challenge_id, created_at, closing_time, status)
values (1, 320, 2, '2024-05-16', '2024-06-16', false),
       (1, 10000, 3, '2024-05-17', '2024-06-17', true),
       (1, 3200, 5, '2024-05-18', '2024-06-18', false),
       (1, 10000, 7, '2024-05-19', '2024-06-19', true),
       (1, 10000, 26, '2024-05-20', '2024-06-20', true),
       (1, 2500, 27, '2024-05-21', '2024-06-21', false),
       (1, 8303, 28, '2024-05-22', '2024-06-22', null),
       (2, 320, 2, '2024-03-24', '2024-04-23', false),
       (2, 1800, 3, '2024-02-05', '2024-03-06', true),
       (2, 3200, 5, '2024-04-23', '2024-04-24', false),
       (2, 2500, 7, '2024-03-23', '2024-04-22', true),
       (2, 2500, 26, '2024-03-23', '2024-04-22', true),
       (2, 2500, 27, '2024-03-23', '2024-04-22', false),
       (2, 5532, 28, '2024-05-22', '2024-06-22', null),
       (3, 320, 2, '2024-03-24', '2024-04-23', false),
       (3, 1800, 3, '2024-02-05', '2024-03-06', true),
       (3, 3200, 5, '2024-04-23', '2024-04-24', false),
       (3, 2500, 7, '2024-03-23', '2024-04-22', true),
       (3, 2500, 26, '2024-03-23', '2024-04-22', true),
       (3, 2500, 27, '2024-03-23', '2024-04-22', false),
       (3, 9180, 28, '2024-05-22', '2024-06-22', null),
       (4, 320, 2, '2024-03-24', '2024-04-23', false),
       (4, 1800, 3, '2024-02-05', '2024-03-06', true),
       (4, 3200, 5, '2024-04-23', '2024-04-24', false),
       (4, 2500, 7, '2024-03-23', '2024-04-22', true),
       (4, 2500, 26, '2024-03-23', '2024-04-22', true),
       (4, 2500, 27, '2024-03-23', '2024-04-22', false),
       (4, 5094, 28, '2024-05-22', '2024-06-22', null),
       (5, 320, 2, '2024-03-24', '2024-04-23', false),
       (5, 1800, 3, '2024-02-05', '2024-03-06', true),
       (5, 3200, 5, '2024-04-23', '2024-04-24', false),
       (5, 2500, 7, '2024-03-23', '2024-04-22', true),
       (5, 2500, 26, '2024-03-23', '2024-04-22', true),
       (5, 2500, 27, '2024-03-23', '2024-04-22', false)
;
INSERT INTO food_tb(name, carbo, protein, fat, kcal, gram, created_at)
VALUES ('바나나', 22.84, 1.09, 0.33, 88, 100, now()),
       ('땅콩', 22.84, 1.09, 0.33, 88, 100, now()),
       ('사과', 22.84, 1.09, 0.33, 88, 100, now()),
       ('닭가슴살', 22.84, 1.09, 0.33, 88, 100, now()),
       ('달걀', 1.1, 12.6, 10.6, 155, 100, now()),
       ('토마토', 3.9, 0.9, 0.2, 18, 100, now()),
       ('브로콜리', 6, 2.8, 0.4, 34, 100, now()),
       ('양배추', 5.8, 1.3, 0.1, 25, 100, now()),
       ('케일', 8.75, 4.28, 0.93, 50, 100, now()),
       ('당근', 9.6, 0.6, 0.2, 41, 100, now()),
       ('삶은 닭가슴살', 0, 29, 1.4, 135, 100, now()),
       ('홍삼', 72.58, 3.03, 0.55, 298, 100, now()),
       ('퀴노아', 64.0, 14.0, 6.0, 368, 100, now()),
       ('연어', 0.0, 20.0, 13.0, 177, 100, now()),
       ('아보카도', 8.53, 2.0, 14.66, 160, 100, now()),
       ('파슬리', 6.33, 3.3, 0.79, 36, 100, now()),
       ('피스타치오', 27.17, 20.16, 45.97, 562, 100, now()),
       ('양파', 9.34, 1.1, 0.1, 40, 100, now()),
       ('아몬드', 21.15, 21.15, 49.42, 579, 100, now()),
       ('프로틴 바', 20.0, 15.0, 10.0, 250, 100, now()),
       ('계란후라이', 1.0, 6.0, 5.0, 80, 100, now()),
       ('크림치즈', 4.0, 5.0, 10.0, 120, 100, now()),
       ('피클', 10.0, 0.5, 0.1, 20, 100, now()),
       ('프로틴 쉐이크', 10.0, 30.0, 3.0, 200, 100, now()),
       ('야채 스프', 7.0, 2.0, 1.0, 50, 100, now()),
       ('오렌지', 8.3, 0.9, 0.2, 43, 100, now()),
       ('비빔밥', 40.0, 10.0, 15.0, 300, 100, now()),
       ('쌀밥', 28.0, 2.0, 0.3, 130, 100, now()),
       ('불고기', 5.2, 17.9, 3.6, 129, 100, now()),
       ('닭가슴살 샐러드', 5.0, 20.0, 3.0, 150, 100, now()),
       ('토마토 스프', 8.2, 2.5, 1.8, 60, 100, now()),
       ('샌드위치', 40.5, 10.2, 10.7, 305, 100, now()),
       ('포도', 17.0, 0.7, 0.2, 69, 100, now()),
       ('호밀빵', 40.0, 8.0, 1.5, 207, 100, now()),
       ('햄버거', 30.0, 15.0, 20.0, 350, 100, now()),
       ('파스타', 25.0, 6.0, 3.5, 160, 100, now()),
       ('우유', 4.7, 3.3, 3.6, 42, 100, now()),
       ('수박', 7.5, 0.6, 0.2, 30, 100, now()),
       ('딸기', 7.7, 0.8, 0.4, 32, 100, now()),
       ('블루베리', 14.5, 0.7, 0.4, 57, 100, now()),
       ('망고', 14.8, 0.8, 0.4, 60, 100, now()),
       ('파인애플', 13.1, 0.5, 0.2, 50, 100, now()),
       ('아몬드 밀크', 0.2, 0.4, 1.1, 14, 100, now()),
       ('녹차', 0.1, 0.2, 0.1, 2, 100, now()),
       ('레몬', 9.3, 1.1, 0.3, 29, 100, now()),
       ('커피', 0.1, 0.3, 0.1, 2, 100, now()),
       ('크래커', 71.0, 7.5, 14.5, 450, 100, now()),
       ('배추김치', 8.0, 1.3, 0.2, 35, 100, now()),
       ('시금치', 1.1, 2.9, 0.4, 23, 100, now()),
       ('깻잎', 2.2, 1.6, 0.2, 16, 100, now()),
       ('미역국', 5.4, 1.5, 0.2, 31, 100, now()),
       ('김', 1.1, 5.7, 0.5, 34, 100, now()),
       ('연두부', 0.9, 4.0, 1.0, 35, 100, now()),
       ('오이', 2.2, 0.6, 0.1, 12, 100, now()),
       ('콩나물', 7.0, 2.1, 0.2, 40, 100, now()),
       ('피클', 5.2, 0.9, 0.2, 12, 100, now()),
       ('호박죽', 8.2, 1.5, 0.2, 45, 100, now()),
       ('콩조림', 12.3, 2.5, 0.4, 70, 100, now()),
       ('브로컬리', 6.0, 2.8, 0.4, 34, 100, now()),
       ('시금치', 1.1, 2.9, 0.4, 23, 100, now()),
       ('가지', 3.5, 0.8, 0.1, 20, 100, now()),
       ('된장국', 4.0, 5.0, 3.0, 70, 100, now()),
       ('고구마', 20.0, 1.6, 0.2, 86, 100, now()),
       ('감자', 17.5, 2.0, 0.1, 77, 100, now()),
       ('그린 스무디', 25.6, 5.2, 2.4, 120, 100, now());

INSERT INTO meal_tb(user_id, eat_time, meal_img, created_at)
VALUES (1, '아침', '이미지', '2024-05-19'),
       (1, '점심', '이미지', '2024-05-19'),
       (1, '저녁', '이미지', '2024-05-19'),
       (1, '간식', '이미지', '2024-05-19'),
       (1, '아침', '이미지', '2024-05-20'),
       (1, '점심', '이미지', '2024-05-20'),
       (1, '저녁', '이미지', '2024-05-20'),
       (1, '간식', '이미지', '2024-05-20'),
       (1, '아침', '이미지', '2024-05-21'),
       (1, '점심', '이미지', '2024-05-21'),
       (1, '저녁', '이미지', '2024-05-21'),
       (1, '간식', '이미지', '2024-05-21')
;
INSERT INTO eat_tb(meal_id, food_id, quantity)
VALUES (1, 30, 1),
       (1, 26, 1),
       (2, 35, 1),
       (2, 56, 1),
       (3, 6, 1),
       (3, 11, 1),
       (4, 17, 1),
       (5, 24, 1),
       (6, 36, 1),
       (6, 56, 1),
       (7, 1, 1),
       (7, 5, 1),
       (8, 2, 1),
       (9, 28, 1),
       (9, 21, 1),
       (9, 62, 1),
       (10, 31, 1),
       (10, 34, 1),
       (11, 27, 1),
       (11, 48, 1),
       (12, 43, 1)
;




INSERT INTO survey_tb(title, status, created_at)
VALUES ('설문조사1', '진행중', '2024-5-17'),
       ('설문조사2', '진행전', '2024-5-20')
;



INSERT INTO survey_question_tb (survey_id, question_item, created_at)
VALUES (1, '하루 평균 수면 시간은 얼마나 되십니까?', '2024-5-17'),
       (1, '자주 겪는 수면 문제는 무엇입니까?', '2024-5-17'),
       (1, '주로 섭취하는 음료는 무엇입니까?', '2024-5-17'),
       (1, '하루 평균 소비하는 카페인의 양은 얼마나 되십니까?', '2024-5-17'),
       (1, '하루에 몇 끼 식사를 하십니까?', '2024-5-17'),
       (1, '한달 평균 음주 횟수는 얼마나 되십니까?', '2024-5-17'),
       (1, '한 번 음주할 때 섭취하는 양은 얼마인가요?', '2024-5-17'),
       (1, '주로 어떤 운동을 하십니까?', '2024-5-17'),
       (1, '운동을 하면서 느끼는 긍정적인 변화는 무엇입니까?', '2024-5-17'),
       (1, '운동을 할 때 가장 중요하게 생각하는 것은 무엇입니까?', '2024-5-17'),
       (1, '주로 어떤 시간에 운동을 하십니까?', '2024-5-17'),
       (1, '일주일에 얼마나 자주 야외 활동을 즐기십니까? (예: 산책, 하이킹)', '2024-5-17'),
       (1, '건강 검진을 얼마나 자주 받으십니까?', '2024-5-17'),
       (1, '자주 경험하는 신체적 불쾌감은 무엇입니까? (예: 두통, 소화 문제)', '2024-5-17'),
       (1, '가장 자주 경험하는 스트레스 유발 요소는 무엇입니까?', '2024-5-17'),
       (1, '주로 어떤 방식으로 스트레스를 해소하십니까?', '2024-5-17'),
       (1, '건강 상태를 유지하기 위해 특별히 신경쓰고 있는 부분은 무엇입니까?', '2024-5-17'),
       (1, '현재 건강 관리에 도움을 받고 있는 자원은 무엇입니까?', '2024-5-17'),
       (1, '현재 건강 관련 목표는 무엇입니까?', '2024-5-17'),
       (2, '주로 얼마나 자주 이 앱을 사용하시나요?', '2024-5-20'),
       (2, '앱의 전반적인 만족도는 어떠신가요?', '2024-5-20'),
       (2, '앱을 사용하는 것이 얼마나 쉬우셨나요?', '2024-5-20'),
       (2, '앱의 디자인과 사용자 인터페이스에 대해 어떻게 생각하시나요?', '2024-5-20'),
       (2, '앱의 기능과 성능에 대해 만족하십니까?', '2024-5-20'),
       (2, '고객 지원 서비스에 대해 만족하십니까??', '2024-5-20'),
       (2, '앱 사용 중 버그나 오류를 경험한 적이 있습니까?', '2024-5-20')

;

INSERT INTO question_choice_tb (survey_id, survey_question_id, choice_number, choice_item, created_at)
VALUES (1, 1, 1, '6시간 미만', '2024-05-17'),
       (1, 1, 2, '6시간 - 8시간', '2024-05-17'),
       (1, 1, 3, '8시간 이상', '2024-05-17'),
       (1, 1, 4, '불규칙', '2024-05-17'),
       (1, 2, 1, '잠을 못 자는 불면증', '2024-05-17'),
       (1, 2, 2, '자주 깨어나는 불규칙한 수면', '2024-05-17'),
       (1, 2, 3, '적절한 수면 시간을 확보하지 못하는 문제', '2024-05-17'),
       (1, 2, 4, '낮에 지속되는 졸음과 낮잠을 못 자는 문제', '2024-05-17'),
       (1, 2, 5, '면 중 호흡 장애로 인한 수면무호흡증', '2024-05-17'),
       (1, 3, 1, '물', '2024-05-17'),
       (1, 3, 2, '커피 또는 차', '2024-05-17'),
       (1, 3, 3, '소프트 드링크 (음료수)', '2024-05-17'),
       (1, 3, 4, '스포츠 음료', '2024-05-17'),
       (1, 4, 1, '하루에 커피 한 잔 미만', '2024-05-17'),
       (1, 4, 2, '하루에 커피 한 잔', '2024-05-17'),
       (1, 4, 3, '하루에 커피 두 잔', '2024-05-17'),
       (1, 4, 4, '하루에 커피 세 잔', '2024-05-17'),
       (1, 4, 5, '하루에 커피 세 잔 이상', '2024-05-17'),
       (1, 5, 1, '3끼 이상', '2024-05-17'),
       (1, 5, 2, '3끼', '2024-05-17'),
       (1, 5, 3, '2끼', '2024-05-17'),
       (1, 5, 4, '1끼', '2024-05-17'),
       (1, 5, 5, '불규칙', '2024-05-17'),
       (1, 6, 1, '전혀 음주하지 않음', '2024-05-17'),
       (1, 6, 2, '한달에 3번 미만', '2024-05-17'),
       (1, 6, 3, '한달에 5번 미만', '2024-05-17'),
       (1, 6, 4, '한달에 10번 미만', '2024-05-17'),
       (1, 6, 5, '한달에 10번 이상', '2024-05-17'),
       (1, 7, 1, '한 두잔 미만', '2024-05-17'),
       (1, 7, 2, '4잔 미만', '2024-05-17'),
       (1, 7, 3, '1병 미만', '2024-05-17'),
       (1, 7, 4, '2병 미만', '2024-05-17'),
       (1, 7, 5, '3병 미만', '2024-05-17'),
       (1, 7, 6, '4병 이상', '2024-05-17'),
       (1, 8, 1, '유산소 운동 (예: 달리기, 수영, 자전거 타기)', '2024-05-17'),
       (1, 8, 2, '근력 운동 (예: 웨이트 트레이닝, 스쿼트, 데드리프트)', '2024-05-17'),
       (1, 8, 3, '요가 또는 필라테스', '2024-05-17'),
       (1, 8, 4, '태권도, 복싱, 테니스 등의 무에타이 클래스', '2024-05-17'),
       (1, 8, 5, '산책이나 등산', '2024-05-17'),
       (1, 9, 1, '체중 감량과 체지방 감소', '2024-05-17'),
       (1, 9, 2, '근육 강화와 체력 향상', '2024-05-17'),
       (1, 9, 3, '스트레스 감소와 긴장 완화', '2024-05-17'),
       (1, 9, 4, '더 나은 수면 품질과 수면 패턴 개선', '2024-05-17'),
       (1, 9, 5, '자기 자신에 대한 자신감 증진', '2024-05-17'),
       (1, 9, 6, '우울증 및 불안 감소', '2024-05-17'),
       (1, 10, 1, '안전한 운동 수행', '2024-05-17'),
       (1, 10, 2, '목표 달성을 위한 꾸준한 노력', '2024-05-17'),
       (1, 10, 3, '적절한 영양 공급과 수분 섭취', '2024-05-17'),
       (1, 10, 4, '적절한 휴식과 회복 시간 확보', '2024-05-17'),
       (1, 10, 5, '몸의 신호를 듣고 적절한 휴식을 취하는 것', '2024-05-17'),
       (1, 10, 6, '몸의 변화를 체감하며 기록하는 것', '2024-05-17'),
       (1, 11, 1, '새벽', '2024-05-17'),
       (1, 11, 2, '아침', '2024-05-17'),
       (1, 11, 3, '오후', '2024-05-17'),
       (1, 11, 4, '저녁', '2024-05-17'),
       (1, 11, 5, '밤', '2024-05-17'),
       (1, 12, 1, '매일', '2024-05-17'),
       (1, 12, 2, '주 2-3회', '2024-05-17'),
       (1, 12, 3, '주 1회', '2024-05-17'),
       (1, 12, 4, '거의 안 함', '2024-05-17'),
       (1, 13, 1, '매년', '2024-05-17'),
       (1, 13, 2, '2년에 한 번', '2024-05-17'),
       (1, 13, 3, '3년에 한 번', '2024-05-17'),
       (1, 13, 4, '불규칙적으로', '2024-05-17'),
       (1, 14, 1, '두통', '2024-05-17'),
       (1, 14, 2, '소화 문제 (예: 속쓰림, 가슴 쓰림)', '2024-05-17'),
       (1, 14, 3, '근육통', '2024-05-17'),
       (1, 14, 4, '만성 피로', '2024-05-17'),
       (1, 14, 5, '관절통', '2024-05-17'),
       (1, 14, 6, '알레르기 반응 (예: 코막힘, 발진)', '2024-05-17'),
       (1, 14, 7, '가슴 답답함', '2024-05-17'),
       (1, 15, 1, '업무 압박과 업무 부담', '2024-05-17'),
       (1, 15, 2, '인간관계 문제 (가족, 친구, 동료 등)', '2024-05-17'),
       (1, 15, 3, '금전적인 문제 (예: 재정적 어려움, 빚)', '2024-05-17'),
       (1, 15, 4, '건강 문제 (예: 질병, 만성 통증)', '2024-05-17'),
       (1, 15, 5, '시간 관리의 어려움', '2024-05-17'),
       (1, 15, 6, '불확실성과 불안감 (예: 미래에 대한 불안, 변화에 대한 불안)', '2024-05-17'),
       (1, 15, 7, '업무와 개인 생활의 균형 유지의 어려움', '2024-05-17'),
       (1, 16, 1, '운동 (예: 걷기, 요가, 수영)', '2024-05-17'),
       (1, 16, 2, '명상 또는 호흡 운동', '2024-05-17'),
       (1, 16, 3, '책 읽기 또는 음악 감상', '2024-05-17'),
       (1, 16, 4, '친구나 가족과 대화하기', '2024-05-17'),
       (1, 16, 5, '취미나 관심사에 집중하기 (예: 그림 그리기, 요리)', '2024-05-17'),
       (1, 16, 6, '자연 속에서 휴식하기 (예: 산책, 피크닉)', '2024-05-17'),
       (1, 16, 7, '정리하거나 정돈하기 (예: 집안 청소, 물건 정리)', '2024-05-17'),
       (1, 17, 1, '균형 잡힌 식습관 유지', '2024-05-17'),
       (1, 17, 2, '충분한 수면을 취하기', '2024-05-17'),
       (1, 17, 3, '정기적인 운동 실천', '2024-05-17'),
       (1, 17, 4, '스트레스 관리를 위한 활동 (예: 명상, 호흡 운동)', '2024-05-17'),
       (1, 17, 5, '정기적인 건강 검진과 의료 상담', '2024-05-17'),
       (1, 17, 6, '신체 활동 유지를 위한 일상적인 스트레칭과 운동', '2024-05-17'),
       (1, 17, 7, '신체적인 증상이나 불편함을 주시하고 적절히 대응하기', '2024-05-17'),
       (1, 18, 1, '건강 관련 앱 또는 웹사이트 (예: 건강 추적 앱, 온라인 건강 정보 사이트)', '2024-05-17'),
       (1, 18, 2, '건강 관련 커뮤니티 또는 온라인 포럼', '2024-05-17'),
       (1, 18, 3, '건강 전문가 (예: 의사, 영양사, 트레이너)', '2024-05-17'),
       (1, 18, 4, '건강 도움을 주는 친구나 가족', '2024-05-17'),
       (1, 18, 5, '건강 관리를 위한 책 또는 자료', '2024-05-17'),
       (1, 18, 6, '건강 관리를 위한 오프라인 그룹 활동 (예: 요가 클래스, 걷기 모임)', '2024-05-17'),
       (1, 18, 7, '건강 보험 혜택을 통한 건강 서비스 이용', '2024-05-17'),
       (1, 19, 1, '체중 감량을 위한 다이어트 실천', '2024-05-17'),
       (1, 19, 2, '규칙적인 운동을 통한 체력 향상', '2024-05-17'),
       (1, 19, 3, '스트레스 관리를 위한 명상이나 호흡 운동 실천', '2024-05-17'),
       (1, 19, 4, '균형 잡힌 식습관을 위한 식단 개선', '2024-05-17'),
       (1, 19, 5, '건강한 수면 패턴 확립을 위한 노력', '2024-05-17'),
       (1, 19, 6, '금연이나 음주량 줄이기와 같은 생활 습관 개선', '2024-05-17'),
       (2, 20, 1, '매일', '2024-05-20'),
       (2, 20, 2, '주 몇 회', '2024-05-20'),
       (2, 20, 3, '월 몇 회', '2024-05-20'),
       (2, 20, 4, '거의 사용하지 않음', '2024-05-20'),
       (2, 21, 1, '매우 만족', '2024-05-20'),
       (2, 21, 2, '만족', '2024-05-20'),
       (2, 21, 3, '보통', '2024-05-20'),
       (2, 21, 4, '불만족', '2024-05-20'),
       (2, 21, 5, '매우 불만족', '2024-05-20'),
       (2, 22, 1, '매우 쉬움', '2024-05-20'),
       (2, 22, 2, '쉬움', '2024-05-20'),
       (2, 22, 3, '보통', '2024-05-20'),
       (2, 22, 4, '어려움', '2024-05-20'),
       (2, 22, 5, '매우 어려움', '2024-05-20'),
       (2, 23, 1, '매우 만족', '2024-05-20'),
       (2, 23, 2, '만족', '2024-05-20'),
       (2, 23, 3, '보통', '2024-05-20'),
       (2, 23, 4, '불만족', '2024-05-20'),
       (2, 23, 5, '매우 불만족', '2024-05-20'),
       (2, 24, 1, '매우 만족', '2024-05-20'),
       (2, 24, 2, '만족', '2024-05-20'),
       (2, 24, 3, '보통', '2024-05-20'),
       (2, 24, 4, '불만족', '2024-05-20'),
       (2, 24, 5, '매우 불만족', '2024-05-20'),
       (2, 25, 1, '매우 만족', '2024-05-20'),
       (2, 25, 2, '만족', '2024-05-20'),
       (2, 25, 3, '보통', '2024-05-20'),
       (2, 25, 4, '불만족', '2024-05-20'),
       (2, 25, 5, '매우 불만족', '2024-05-20'),
       (2, 25, 6, '고객 지원 서비스를 이용해본 적 없음', '2024-05-20'),
       (2, 26, 1, '전혀 없음', '2024-05-20'),
       (2, 26, 2, '거의 없음', '2024-05-20'),
       (2, 26, 3, '가끔 있음', '2024-05-20'),
       (2, 26, 4, '자주 있음', '2024-05-20'),
       (2, 26, 5, '매우 자주 있음', '2024-05-20')
;



INSERT INTO choice_answer_tb (user_id, survey_id, survey_question_id, question_choice_id, created_at)
VALUES (1, 1, 1, 1, now()),
       (2, 1, 1, 2, now()),
       (3, 1, 1, 3, now()),
       (4, 1, 1, 4, now()),
       (5, 1, 1, 4, now()),
       (1, 1, 2, 5, now()),
       (2, 1, 2, 6, now()),
       (3, 1, 2, 7, now()),
       (4, 1, 2, 9, now()),
       (5, 1, 2, 6, now()),
       (1, 1, 3, 10, now()),
       (2, 1, 3, 11, now()),
       (3, 1, 3, 12, now()),
       (4, 1, 3, 13, now()),
       (5, 1, 3, 10, now()),
       (1, 1, 4, 14, now()),
       (2, 1, 4, 15, now()),
       (3, 1, 4, 16, now()),
       (4, 1, 4, 18, now()),
       (5, 1, 4, 17, now()),
       (1, 1, 5, 19, now()),
       (2, 1, 5, 20, now()),
       (3, 1, 5, 21, now()),
       (4, 1, 5, 23, now()),
       (5, 1, 5, 19, now()),
       (1, 1, 6, 24, now()),
       (2, 1, 6, 24, now()),
       (3, 1, 6, 24, now()),
       (4, 1, 6, 27, now()),
       (5, 1, 6, 28, now()),
       (1, 1, 7, 29, now()),
       (2, 1, 7, 34, now()),
       (3, 1, 7, 34, now()),
       (4, 1, 7, 34, now()),
       (5, 1, 7, 34, now()),
       (1, 1, 8, 35, now()),
       (2, 1, 8, 36, now()),
       (3, 1, 8, 37, now()),
       (4, 1, 8, 39, now()),
       (5, 1, 8, 39, now()),
       (1, 1, 9, 40, now()),
       (2, 1, 9, 41, now()),
       (3, 1, 9, 42, now()),
       (4, 1, 9, 45, now()),
       (5, 1, 9, 41, now()),
       (1, 1, 10, 46, now()),
       (2, 1, 10, 47, now()),
       (3, 1, 10, 48, now()),
       (4, 1, 10, 51, now()),
       (5, 1, 10, 51, now()),
       (1, 1, 11, 52, now()),
       (2, 1, 11, 56, now()),
       (3, 1, 11, 56, now()),
       (4, 1, 11, 56, now()),
       (5, 1, 11, 56, now()),
       (1, 1, 12, 57, now()),
       (2, 1, 12, 58, now()),
       (3, 1, 12, 59, now()),
       (4, 1, 12, 60, now()),
       (5, 1, 12, 60, now()),
       (1, 1, 13, 61, now()),
       (2, 1, 13, 62, now()),
       (3, 1, 13, 63, now()),
       (4, 1, 13, 64, now()),
       (5, 1, 13, 62, now()),
       (1, 1, 14, 65, now()),
       (2, 1, 14, 66, now()),
       (3, 1, 14, 67, now()),
       (4, 1, 14, 71, now()),
       (5, 1, 14, 69, now()),
       (1, 1, 15, 72, now()),
       (2, 1, 15, 73, now()),
       (3, 1, 15, 74, now()),
       (4, 1, 15, 78, now()),
       (5, 1, 15, 76, now()),
       (1, 1, 16, 79, now()),
       (2, 1, 16, 80, now()),
       (3, 1, 16, 81, now()),
       (4, 1, 16, 85, now()),
       (5, 1, 16, 80, now()),
       (1, 1, 17, 86, now()),
       (2, 1, 17, 87, now()),
       (3, 1, 17, 88, now()),
       (4, 1, 17, 92, now()),
       (5, 1, 17, 90, now()),
       (1, 1, 18, 93, now()),
       (2, 1, 18, 94, now()),
       (3, 1, 18, 95, now()),
       (4, 1, 18, 99, now()),
       (5, 1, 18, 93, now()),
       (1, 1, 19, 105, now()),
       (2, 1, 19, 105, now()),
       (3, 1, 19, 105, now()),
       (4, 1, 19, 105, now()),
       (5, 1, 19, 105, now()),
       (2, 2, 20, 106, now()),
       (3, 2, 20, 108, now()),
       (4, 2, 20, 109, now()),
       (2, 2, 21, 110, now()),
       (3, 2, 21, 112, now()),
       (4, 2, 21, 114, now()),
       (2, 2, 22, 115, now()),
       (3, 2, 22, 117, now()),
       (4, 2, 22, 119, now()),
       (2, 2, 23, 120, now()),
       (3, 2, 23, 122, now()),
       (4, 2, 23, 124, now()),
       (2, 2, 24, 125, now()),
       (3, 2, 24, 127, now()),
       (4, 2, 24, 129, now()),
       (2, 2, 25, 130, now()),
       (3, 2, 25, 131, now()),
       (4, 2, 25, 132, now()),
       (2, 2, 26, 136, now()),
       (3, 2, 26, 139, now()),
       (4, 2, 26, 140, now())
;

INSERT INTO do_survey_tb(user_id, survey_id, created_at)
VALUES (1, 1, '2024-5-17'),
       (2, 1, '2024-5-18'),
       (3, 1, '2024-5-18'),
       (4, 1, '2024-5-19'),
       (5, 1, '2024-5-20'),
       (2, 2, '2024-5-20'),
       (3, 2, '2024-5-20'),
       (4, 2, '2024-5-20')
;

-- INSERT INTO do_survey_tb(user_id, survey_id, created_at)
-- VALUES (2, 1, '2024-5-18'),
--        (3, 1, '2024-5-18'),
--        (4, 1, '2024-5-19'),
--        (5, 1, '2024-5-20'),
--        (2, 2, '2024-5-20'),
--        (3, 2, '2024-5-20'),
--        (4, 2, '2024-5-20')
-- ;

-- INSERT INTO choice_answer_tb (user_id, survey_id, survey_question_id, question_choice_id, created_at)
-- VALUES
--     (2, 1, 1, 2, now()),
--     (3, 1, 1, 3, now()),
--     (4, 1, 1, 4, now()),
--     (5, 1, 1, 4, now()),
--     (2, 1, 2, 6, now()),
--     (3, 1, 2, 7, now()),
--     (4, 1, 2, 9, now()),
--     (5, 1, 2, 6, now()),
--     (2, 1, 3, 11, now()),
--     (3, 1, 3, 12, now()),
--     (4, 1, 3, 13, now()),
--     (5, 1, 3, 10, now()),
--     (2, 1, 4, 15, now()),
--     (3, 1, 4, 16, now()),
--     (4, 1, 4, 18, now()),
--     (5, 1, 4, 17, now()),
--     (2, 1, 5, 20, now()),
--     (3, 1, 5, 21, now()),
--     (4, 1, 5, 23, now()),
--     (5, 1, 5, 19, now()),
--     (2, 1, 6, 24, now()),
--     (3, 1, 6, 24, now()),
--     (4, 1, 6, 27, now()),
--     (5, 1, 6, 28, now()),
--     (2, 1, 7, 34, now()),
--     (3, 1, 7, 34, now()),
--     (4, 1, 7, 34, now()),
--     (5, 1, 7, 34, now()),
--     (2, 1, 8, 36, now()),
--     (3, 1, 8, 37, now()),
--     (4, 1, 8, 39, now()),
--     (5, 1, 8, 39, now()),
--     (2, 1, 9, 41, now()),
--     (3, 1, 9, 42, now()),
--     (4, 1, 9, 45, now()),
--     (5, 1, 9, 41, now()),
--     (2, 1, 10, 47, now()),
--     (3, 1, 10, 48, now()),
--     (4, 1, 10, 51, now()),
--     (5, 1, 10, 51, now()),
--     (2, 1, 11, 56, now()),
--     (3, 1, 11, 56, now()),
--     (4, 1, 11, 56, now()),
--     (5, 1, 11, 56, now()),
--     (2, 1, 12, 58, now()),
--     (3, 1, 12, 59, now()),
--     (4, 1, 12, 60, now()),
--     (5, 1, 12, 60, now()),
--     (2, 1, 13, 62, now()),
--     (3, 1, 13, 63, now()),
--     (4, 1, 13, 64, now()),
--     (5, 1, 13, 62, now()),
--     (2, 1, 14, 66, now()),
--     (3, 1, 14, 67, now()),
--     (4, 1, 14, 71, now()),
--     (5, 1, 14, 69, now()),
--     (2, 1, 15, 73, now()),
--     (3, 1, 15, 74, now()),
--     (4, 1, 15, 78, now()),
--     (5, 1, 15, 76, now()),
--     (2, 1, 16, 80, now()),
--     (3, 1, 16, 81, now()),
--     (4, 1, 16, 85, now()),
--     (5, 1, 16, 80, now()),
--     (2, 1, 17, 87, now()),
--     (3, 1, 17, 88, now()),
--     (4, 1, 17, 92, now()),
--     (5, 1, 17, 90, now()),
--     (2, 1, 18, 94, now()),
--     (3, 1, 18, 95, now()),
--     (4, 1, 18, 99, now()),
--     (5, 1, 18, 93, now()),
--     (2, 1, 19, 105, now()),
--     (3, 1, 19, 105, now()),
--     (4, 1, 19, 105, now()),
--     (5, 1, 19, 105, now()),
--     (2, 2, 20, 106, now()),
--     (3, 2, 20, 108, now()),
--     (4, 2, 20, 109, now()),
--     (2, 2, 21, 110, now()),
--     (3, 2, 21, 112, now()),
--     (4, 2, 21, 114, now()),
--     (2, 2, 22, 115, now()),
--     (3, 2, 22, 117, now()),
--     (4, 2, 22, 119, now()),
--     (2, 2, 23, 120, now()),
--     (3, 2, 23, 122, now()),
--     (4, 2, 23, 124, now()),
--     (2, 2, 24, 125, now()),
--     (3, 2, 24, 127, now()),
--     (4, 2, 24, 129, now()),
--     (2, 2, 25, 130, now()),
--     (3, 2, 25, 131, now()),
--     (4, 2, 25, 132, now()),
--     (2, 2, 26, 136, now()),
--     (3, 2, 26, 139, now()),
--     (4, 2, 26, 140, now())
-- ;