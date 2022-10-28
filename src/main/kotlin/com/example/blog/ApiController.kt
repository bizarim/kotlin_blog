package com.example.blog

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.DefaultBlockParameterName
import org.web3j.protocol.core.methods.response.EthGetBalance
import org.web3j.protocol.core.methods.response.Web3ClientVersion
import org.web3j.protocol.http.HttpService
import java.math.BigInteger

@RestController
@RequestMapping("/api")
class HtmlController {

    @GetMapping("/blog")
    fun blog(): String {
        val web3j: Web3j = Web3j.build(HttpService(""))
        val blockNumber: BigInteger = web3j.ethBlockNumber().sendAsync().get().blockNumber
        val balance: EthGetBalance? = web3j.ethGetBalance("",
            DefaultBlockParameterName.LATEST).sendAsync().get()
        println(balance?.balance);
        println(blockNumber)

        return blockNumber.toString()
//        return "blog"
    }

    @PostMapping("/add")
    fun add(): String {
        return  ""
    }
}