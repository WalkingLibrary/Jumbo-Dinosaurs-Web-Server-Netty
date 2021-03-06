package com.jumbodinosaurs.webserver.commands.domain;

import com.jumbodinosaurs.devlib.commands.MessageResponse;
import com.jumbodinosaurs.devlib.commands.exceptions.WaveringParametersException;
import com.jumbodinosaurs.devlib.util.OperatorConsole;
import com.jumbodinosaurs.webserver.auth.server.captcha.CaptchaKey;
import com.jumbodinosaurs.webserver.domain.DomainManager;
import com.jumbodinosaurs.webserver.domain.util.SecureDomain;

public class SetDomainCaptcha extends DomainCommand
{
    @Override
    public MessageResponse getExecutedMessage()
            throws WaveringParametersException
    {
        System.out.println("Enter the domain you'd like to Change:");
        String domain = OperatorConsole.getEnsuredAnswer();
    
        SecureDomain domainToEdit = DomainManager.getDomain(domain);
        
        if(domainToEdit == null)
        {
            return new MessageResponse("No Domain named " + domain + " in the DomainManager");
        }
        
        System.out.println("Enter the Captcha Public Key:");
        String captchaPublicKey = OperatorConsole.getEnsuredAnswer();
        System.out.println("Enter the Captcha Private Key:");
        String captchaPrivateKey = OperatorConsole.getEnsuredAnswer();
        
        CaptchaKey newCaptchaKey = new CaptchaKey(captchaPublicKey, captchaPrivateKey);
    
        domainToEdit.setCaptchaKey(newCaptchaKey);
        DomainManager.updateDomain(domainToEdit);
        
        return new MessageResponse("The Captcha Key was added to " + domain);
    }
    
    @Override
    public String getHelpMessage()
    {
        return "Allows the User to tie a captcha private and public key to a Domain";
    }
}
