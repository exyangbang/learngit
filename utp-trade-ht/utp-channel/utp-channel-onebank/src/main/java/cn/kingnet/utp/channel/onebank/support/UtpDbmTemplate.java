package cn.kingnet.utp.channel.onebank.support;

import cn.onebank.dmb.client.api.DMB;
import cn.onebank.dmb.client.api.Request;
import cn.onebank.dmb.client.api.Response;
import cn.onebank.dmb.client.exception.DMBException;
import cn.onebank.dmb.common.message.ServiceCode;

import javax.annotation.PreDestroy;
import java.util.Set;

/**
 * @author zhongli
 * @date 2018/10/11
 */
public class UtpDbmTemplate {
    private final DMB dmb;

    public UtpDbmTemplate(DMB dmb) {
        this.dmb = dmb;
    }

    public DMB getDmb() {
        return dmb;
    }

    public final void registerServices(Set<ServiceCode> services, long timeout) throws DMBException {
        dmb.registerServices(services, timeout);
    }

    public final void cancelServices(Set<ServiceCode> services, long timeout) throws DMBException {
        dmb.cancelServices(services, timeout);
    }

    public final Response sendRequest(Request request) throws DMBException {
        return dmb.sendRequest(request);
    }

    public final void sendRequestWithAsync(Request request) throws DMBException {
        dmb.sendRequestWithAsync(request);
    }

    public final void sendReply(Response response) throws DMBException {
        dmb.sendReply(response);
    }

    public final void publish(Request request) throws DMBException {
        dmb.publish(request);
    }

    @PreDestroy
    public void preDestroy() {
        try {
            dmb.shutdown();
            dmb.destory();
        } catch (Throwable e) {

        }
    }

}
