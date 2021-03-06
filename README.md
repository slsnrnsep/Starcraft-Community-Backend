# Starcraft-Community-Backend
스타크래프트 전략공유 사이트입니다(4주차 미니프로젝트)

### 목차
- [개발 배경](#개발-배경)
- [개발 과정](#개발-과정)
  - [개발 기간](#1-개발-기간)
  - [사용 언어](#2-사용-언어)
  - [프로젝트 목표](#3-프로젝트-)
  - [와이어프레임 설계](#4-와이어프레임-설계(Figma-활용))
  - [API 설계](#5-API-설계)
- [개발 결과](#개발-결과)
  - [구현한 기능](#1구현한-기능)
  - [실제 서비스 모습](#2-실제-서비스-모습)
  - [피드백](#3-회고-및-피드백)
---
### 개발 배경
- 오픈된 공간에서 유저 서로가 스타크래프트라는 게임의 정보를 공유하는 공간입니다!
- 개발 구상 단계에서 영화소개나 음악소개 사이트는 많은데 게임이야기를 공유하는 사이트는 잘 없어서 개발하게 되었습니다.
- 이번 프로젝트는 각자가 주특기`개인의 선호에 따라 백엔드(Java Spring), 프론트엔드(React) 선택` 를 공부하고 진행하는 첫 협업이었습니다.
---
### 개발 과정

#### 1. 개발 기간
- `2021년 10월 11일(월) ~ 2021년 10월 16일(토) / 총 6일`
- `설계 1일 / 개발 5일`

#### 2. 사용 언어
- **Languages** : Java(Backend), React(Frontend)
- **Framework** : Spring
- **DB** : MySQL, H2(테스트용)

#### 3. 프로젝트 목표
1. 서로 다른 개발환경에서의 연동(CORS)
2. 회원가입 & Spring에서 JWT 방식의 로그인
3. 게시판 구현(CRUD 구현, 이미지 업로드)



#### 4. 와이어프레임 설계(Figma 활용)

- 회원가입

![회원가입1](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/9c892a8e-3133-482f-a656-69f54d4004da/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20211016%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20211016T054032Z&X-Amz-Expires=86400&X-Amz-Signature=d564efe6d2fc6d88600cd18e4d02105449546bcfb0540bc19cad99bfe700f7aa&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22)

2. 로그인

![로그인](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/e3afe4e3-f4ee-47f2-98e7-f7c9655aa334/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20211016%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20211016T054041Z&X-Amz-Expires=86400&X-Amz-Signature=2a13daff79b62a21127bb69f85147bcfef85c709f651e9232514d2322d70a083&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22)

3. 메인페이지

![메인페이지](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/6935fafd-f3b1-44a3-bf0f-d3689f98ab79/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20211016%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20211016T054021Z&X-Amz-Expires=86400&X-Amz-Signature=ff7158d572acc7e5786e13bd4ace41d6ebab230a05d8958411fd462d578dfae2&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22)

4. 상세 페이지

![상세 페이지](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/23168c02-b0c2-448b-9b29-f8314713d3bc/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20211016%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20211016T053946Z&X-Amz-Expires=86400&X-Amz-Signature=ec6b6705ee8326c4ff9d47116d4afeeced50ba2eb7bb71ad44c3f2137c82cd27&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22)

5. 게시글 작성

![게시글 작성 페이지](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/247b60df-d624-498c-85f9-24524f5d78ba/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAT73L2G45O3KS52Y5%2F20211016%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20211016T054056Z&X-Amz-Expires=86400&X-Amz-Signature=360e673369b9ffd579bd599a6c8e9c48abd2a162d43ab2d3f71840ce870f7b35&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22)

#### 5. API 설계
https://www.notion.so/744bb1a68c824eaab96598027d47b487?v=c4b03910f33443929cfc305d4c65cb77

---
### 개발 결과

#### 1.구현한 기능
**1. CORS 문제 해결**

본 프로젝트에서는 프론트엔드(React.js)와 백엔드(Spring)가 각각 다른 환경에서 개발했습니다. 즉, 각 단의 독립적인 서버(도메인)를 열어 작업해야 했습니다.<br></br>
서버단에서는 필요한 API를 모두 생성/관리하고, 프론트엔드에서는 서버에서 구축한 API를 활용하도록 했습니다.<br></br>
이 과정에서 CORS 문제가 발생하기도 했습니다. CORS는 웹개발을 하다가 흔히 만날 수 있는 이슈입니다. 대개는 프론트엔드 개발시에 로컬에서 API 서버에 요청을 보낼 때 흔하게 발생합니다.
서로 다른 도메인간에 자원을 공유하는 것을 뜻합니다. 대부분의 브라우저에서는 이를 기본적으로 차단하며, 서버측에서 헤더를 통해서 사용가능한 자원을 알려준다는 것을 배웠습니다.
```java
//CORS 허용 설정 부분
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://s3의 주소","http://localhost:3000","http://도메인주소/")
                //클라이언트 로컬 주소임. 클라이언트에서 내 서버의 api에 접근 시 허용에 관한 부분. CORS.
                //2개 이상의 origin에 대해서 허용할 수 있음!
                .allowedMethods("POST","GET","PUT","DELETE","HEAD","OPTIONS") // 클라이언트에서 요청하는 메소드 어디까지 허용할 것인가.
                .allowCredentials(true);
    }
```

**2. Spring 환경에서 JWT 방식의 로그인**

이번 프로젝트에서 가장 애먹었던 부분입니다. 로그인에 성공한 유저에게 **토큰**을 발행하여 이를 프론트단에 보내고, 프론트단에서는 서버의 API에 접근할 때 이 **토큰**을 포함하고,
서버에서는 받은 **토큰**을 검증하는 단계가 계속 이루어지게 해야 했습니다.

![jwt1](https://user-images.githubusercontent.com/85334989/128339887-413af3a0-65e5-4394-8f07-017923ee2b48.png)
![jwt2](https://user-images.githubusercontent.com/85334989/128339853-11304c4e-44ed-4a82-ac2f-f1464b5eb623.png)

계속 고민했던 부분은 그림의 `6번` 과정이었습니다. 서버에서 토큰 발행하고, 클라이언트에서 토큰을 포함해 요청하는 것 까지는 성공했으나, **서버에서 토큰을 어떻게 받고 검증할 지**가 가장 큰 고민이었습니다. **ARC**라는 API 테스트 툴로 유저 정보 인증이 필요한 API에 request 할 경우, 계속해서 오류가 발생했습니다.<br></br>

개발기간이 총 6일이 주어졌는데, 이 문제를 해결하기 위해서 총 3.5일의 시간이 걸렸습니다.

**오류가 계속 발생했던 원인은 클라이언트에서 서버로 보내는 요청의 Header의 이름이 클라이언트-서버 간에 일치하지 않았기 때문이었습니다**
```java
//서버의 JwtTokenProvider.java
public String resolveToken(HttpServletRequest request) {
     return request.getHeader("X-AUTH-TOKEN");
 }
```

#### 2. 실제 서비스 모습
[시연 영상 YouTube 이동](https://www.youtube.com/)

#### 3. 회고 및 피드백
- 백엔드, 프론트엔드로 분리된 개발환경에서 각자 개발을 하고, 이를 한 개의 결과물로 만드는 과정에서 나타나는 문제(CORS, JWT인증)를 겪고 이를 해결해보는 좋은 경험이었습니다.
- 주특기를 선택하고 공부하기 이전에 프로젝트를 진행할 때에는 프론트엔드, 백엔드 구분 없이 모두가 동일한 Repository의 동일한 file을 갖고 기능단위로 역할을 맡아 개발을 했었습니다. 
- 최초에 그렸던 와이어프레임과 완전히 동일하게(view)는 구현하지 못했지만, 기능적으로는 90% 이상 달성한 뿌듯한 프로젝트입니다.
- Spring 공부를 시작하고 혼자 프로젝트를 진행할 때에는 썩 예쁜 페이지를 만들지 못했지만, 프론트엔드 개발자들과 협업하면서 온전히 백엔드 개발에만 몰입할 수 있었고, 보기에도 예쁜 페이지를 만들 수 있었습니다.
- 이번 프로젝트에서는 `좋아요`, `프로필사진`의 소셜 기능을 담지 못했지만, 추후 더욱 연구해서 꼭 적용해보고 싶다는 생각을 했습니다.
