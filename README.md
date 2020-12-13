# react with spring

리액트 프레임웤 테스트용 저장소는.  
서버 사이드는 spring. 띠용? 🙄

#### environments

- jdk 10 or higher
- maven
- spring 5.2.4(java config base)
- tomcat 9
- react.js 16.13.0

## 코딩 가이드

### example

#### 파일 읽어서 json으로 응답

```java
@GetMapping(path = "/react/readSample", produces = "application/json")
public Map<String, Object> readSample(HttpServletResponse resp) throws IOException {
	HashMap<String, Object> json = jsonConverter.readValue(new ClassPathResource("data/sample.json").getFile(), 
			new TypeReference<HashMap<String, Object>>() {});
	logger.debug("{}", json);
	return json;
}
```

#### react/test.jsp 응답

```java
@GetMapping("/react/test")
public ModelAndView test(ModelAndView model) {
	return model;
}
```
