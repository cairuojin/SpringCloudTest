//package com.gjsyoung.SpringCloudTest_MovieProvider.controller;
//
//import com.gjsyoung.SpringCloudTest_MovieProvider.domain.User;
//import com.gjsyoung.SpringCloudTest_MovieProvider.service.UserFeignCline;
//import feign.Client;
//import feign.Contract;
//import feign.Feign;
//import feign.auth.BasicAuthRequestInterceptor;
//import feign.codec.Decoder;
//import feign.codec.Encoder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
//import org.springframework.context.annotation.Import;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Base64;
//
//@Import(FeignClientsConfiguration.class)
//@RestController
//public class MoviePersonalController {
//
//    private UserFeignCline userAdminFeignCline;
//
//    private UserFeignCline userUserFeignCline;
//
//
//    @Autowired
//    public MoviePersonalController(Decoder decoder, Encoder encoder, Client client, Contract contract){
//        this.userAdminFeignCline = Feign
//                .builder()
//                .client(client)
//                .encoder(encoder)
//                .decoder(decoder)
//                .contract(contract)
//                .requestInterceptor(
//                        new BasicAuthRequestInterceptor("admin","123456")
//                )
//                .target(UserFeignCline.class, "http://SpringCloudTest-UserProvider/");
//
//        this.userUserFeignCline = Feign
//                .builder()
//                .client(client)
//                .encoder(encoder)
//                .decoder(decoder)
//                .contract(contract)
//                .requestInterceptor(
//                        new BasicAuthRequestInterceptor("user","111111")
//                )
//                .target(UserFeignCline.class, "http://SpringCloudTest-UserProvider/");
//    }
//
//
//
//    /**
//     * 调用用户微服务
//     * @param id
//     * @return
//     */
//    @RequestMapping("/userUser/{id}")
//    public User movieTest1(@PathVariable Long id){
//        return userUserFeignCline.findUser(id);
//    }
//    @RequestMapping("/adminUser/{id}")
//    public User movieTest2(@PathVariable Long id){
//        return userAdminFeignCline.findUser(id);
//    }
//}
