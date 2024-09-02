# 깃허브 디스커션 ↔  매터모스트 알림 봇
![image](https://github.com/user-attachments/assets/6b90c188-bc2e-4af6-b5b8-bf9b136f9cea)

**Github Repository의 discussion에 새 글이 올라오면, Webhook을 활용해 Mattermost에 알림을 전송하는 봇 프로그램입니다.**

## 🔧 Tech
- Springboot 3.3.2
- Docker
- Aws Lambda

## 📖 제작 동기
[블글의 의지](https://github.com/SSAFY12th/beulgeul_ui-uiji/discussions)는 1주 1포스팅을 목표로 기술 블로그를 운영하는 스터디 입니다.

스터디원들은 포스팅을 완료 후 아래와 같이 github의 discussion 기능을 활용하여 인증합니다.

<img src="https://github.com/user-attachments/assets/39aaffa6-aaf0-4ad5-89db-c5987c1960b4" height="350"/>

<br>

하지만 이 방식에는 몇 가지 불편한 점이 있었습니다:

1. 다른 스터디원이 새 글을 올렸을 때 즉시 알 수 있는 방법이 없었습니다.
2. 새 글을 확인하려면 매번 GitHub에 직접 접속해야 했습니다.
3. 결국, 포스팅 여부를 확인하는 데 불필요한 시간이 소요되었습니다.

> "Webhook을 활용하면 개선할 수 있지 않을까?"

Webhook을 활용해 SSAFY에서 사용하는 메신저인 Mattermost와 Github를 연결하였습니다.

마치 블로그 구독 알림 서비스와 같이 사용할 수 있도록 만들었습니다!


## [👨‍💻 개발 과정](https://velog.io/@skb0516/github-mattermost-%EC%9B%B9%ED%9B%85-%EC%97%B0%EB%8F%99%EB%B8%94%EA%B8%80-%EB%B4%87-%EC%A0%9C%EC%9E%91%EA%B8%B0)

## 🚀 동작

### **Github discussion 작성**

![image](https://github.com/user-attachments/assets/3d3443c6-a2f1-453b-996e-925b867024e0)

### **Mattermost 알림**

![image](https://github.com/user-attachments/assets/2e03fbd7-b3bf-445e-b21e-54628ce22821)
