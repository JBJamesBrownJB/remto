package io.portsOut

import domain.ToDo
import org.apache.commons.mail.DefaultAuthenticator
import org.apache.commons.mail.HtmlEmail
import java.net.URL

internal class EmailAdapter: IAdapter{
    override fun Notify(todo: ToDo) {
        val senderEmail = "remto@remto.remto"
        val username = ""
        val password = ""
        val toMail = ""

        val email = HtmlEmail()
        email.hostName = "smtp.sendgrid.net"
        email.setSmtpPort(465)
        email.setAuthenticator(DefaultAuthenticator(username, password))
        email.isSSLOnConnect = true
        email.setFrom(senderEmail)
        email.addTo(toMail)
        email.subject = "Test email with inline image sent using Kotlin"
        val kotlinLogoURL = URL("https://kotlinlang.org/assets/images/twitter-card/kotlin_800x320.png")
        val cid = email.embed(kotlinLogoURL, "Kotlin logo")
        email.setHtmlMsg("<html><h1>Kotlin logo</h1><img src=\"cid:$cid\"></html>")
        email.send()
    }
}