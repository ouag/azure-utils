package com.ouag.demo.keyvaultdemo;

import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.models.SecretProperties;
import com.microsoft.aad.msal4j.ClientSecret;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;


@Slf4j
@AllArgsConstructor
@RestController
public class SecretAccessController {


    private SecretClient secretClient;

    @GetMapping(path = "/secret")
    public ResponseEntity<String> getSecret(@RequestParam(value = "secretKey") String secretKey) {
        return ResponseEntity.ok(secretClient.getSecret(secretKey).getValue());
    }

    @GetMapping(path = "/secrets")
    public ResponseEntity<Map> getSecrets() {
         return ResponseEntity.ok(secretClient.listPropertiesOfSecrets().stream()
                 .collect(Collectors.toMap(SecretProperties::getName,
                         (SecretProperties secretProperties ) -> secretClient.getSecret(secretProperties.getName(), secretProperties.getVersion()))));

    }


}
