package hansung.ac.kr.src.dto;

public class LocalDB {

    private String[] chicken_sausage = {
            "리얼원 닭가슴살 소시지 매콤치즈 100g?19",
            "리얼원 닭가슴살 소시지 청양고추 100g?22",
            "잇메이트 닭가슴살 소시지 고추맛 100g?20",
            "잇메이트 닭가슴살 소시지 마늘맛 100g?19",
            "잇메이트 닭가슴살 소시지 카레맛 100g?23",
            "햇살닭 닭가슴살 비엔나 불닭맛 100g?16",
            "맛있닭 닭가슴살 소시지 훈제맛 140g?23",
            "맛있닭 닭가슴살 소시지 할라피뇨맛 140g?20",
            "맛있닭 닭가슴살 소시지 견과맛 140g?21",
            "맛있닭 닭가슴살 소시지 현미맛 140g?20"
    };

    private String[] chicken_ball = {
            "맛있닭 닭가슴살 볼 깻잎맛 100g?23",
            "맛있닭 닭가슴살 볼 치즈맛 100g?23",
            "맛있닭 닭가슴살 볼 스파이시 100g?23",
            "맛있닭 닭가슴살 볼 자반김 100g?23",
            "맛있닭 닭가슴살 볼 오리지널 100g?23"
    };

    private String[] sauce_chicken = {
            "맛있닭 소스 통 닭가슴살 갈릭 100g?23",
            "맛있닭 소스 통 닭가슴살 깐풍기 100g?22",
            "맛있닭 소스 통 닭가슴살 레몬 크림 100g?21",
            "맛있닭 소스 통 닭가슴살 매콤 바베큐 100g?21",
            "맛있닭 소스 통 닭가슴살 매콤 칠리 100g?23",
            "맛있닭 한입 소스 닭가슴살 까르보나라 80g?24",
            "맛있닭 한입 소스 닭가슴살 블랙소이 80g?23",
            "맛있닭 한입 소스 닭가슴살 짜장 70g?23",
            "맛있닭 한입 소스 닭가슴살 짬뽕 70g?23",
            "맛있닭 한입 소스 닭가슴살 크림 머스타드 80g?24"
    };

    private String[] beef = {
            "맛있소 소고기 스테이크 오리지널 100g?20",
            "맛있소 소고기 스테이크 청양고추 100g?19",
            "맛있소 소고기볼 마늘 100g?27",
            "잇메이트 소고기볼 오리지널 100g?20",
            "잇메이트 소고기볼 청양고추 100g?19"
    };

    private String[] fish = {
            "랭킹수산 렌지에 구워먹는 고등어구이 140g?22",
            "랭킹수산 렌지에 구워먹는 꽁치구이 120g?20",
            "랭킹수산 렌지에 구워먹는 삼치구이 100g?20",
            "랭킹수산 렌지에 구워먹는 연어구이 100g?20",
            "랭킹수산 렌지에 구워먹는 장어구이 데리야끼맛 140g?24",
            "랭킹수산 렌지에 구워먹는 장어구이 매운맛 140g?24"
    };

    private String[] protein = {
            "임팩트 웨이 프로틴 망고맛?21",
            "임팩트 웨이 프로틴 말차맛?21",
            "임팩트 웨이 프로틴 다크 초콜릿맛?21",
            "임팩트 웨이 프로틴 스트로베리맛?21",
            "임팩트 웨이 프로틴 밀크티맛?21",
            "임팩트 웨이 프로틴 블루베리맛?21",
            "임팩트 웨이 프로틴 바나나맛?21",
            "임팩트 웨이 프로틴 바닐라맛?21",
            "임팩트 웨이 프로틴 요거트맛?21",
            "임팩트 웨이 프로틴 무맛?21"
    };

    private String[] chicken_steak = {
            "맛있닭 닭가슴살 스테이크 오리지널맛?22",
            "맛있닭 닭가슴살 스테이크 갈릭맛?23",
            "맛있닭 닭가슴살 스테이크 고추맛?22",
            "맛있닭 닭가슴살 스테이크 호박맛?21",
            "맛있닭 닭가슴살 스테이크 야채맛?22",
            "맛있닭 닭가슴살 스테이크 토마토맛?21",
            "맛있닭 닭가슴살 스테이크 로스트갈릭맛?21",
            "맛있닭 닭가슴살 스테이크 자색고구마 까르보나라맛?20",
            "맛있닭 닭가슴살 스테이크 매콤토마토맛?21",
            "맛있닭 닭가슴살 스테이크 흑마늘맛?22"
    };

    private String[] appetizer = {
            "맛있닭 닭가슴살 한끼 어묵만두 매콤 100g?21",
            "맛있닭 닭가슴살 한끼 어묵만두 오리지널 100g?21",
            "잇메이트 닭가슴살 어묵바 매콤 80g?16",
            "잇메이트 닭가슴살 어묵바 오리지널 80g?16",
            "잇메이트 버터구이 오징어 60g?15"
    };

    private String[][] product = {chicken_sausage, chicken_ball, sauce_chicken, beef, fish, chicken_steak};

    // Getter methods for each array
    public String[] getChickenSausage() {
        return chicken_sausage;
    }

    public String[] getChickenBall() {
        return chicken_ball;
    }

    public String[] getSauceChicken() {
        return sauce_chicken;
    }

    public String[] getBeef() {
        return beef;
    }

    public String[] getFish() {
        return fish;
    }

    public String[] getProtein() {
        return protein;
    }

    public String[] getChickenSteak() {
        return chicken_steak;
    }

    public String[] getAppetizer() {
        return appetizer;
    }

    public String[][] getProduct() {
        return product;
    }
}
