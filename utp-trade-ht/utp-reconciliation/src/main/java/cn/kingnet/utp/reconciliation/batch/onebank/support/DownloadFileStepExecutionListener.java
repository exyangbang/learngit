package cn.kingnet.utp.reconciliation.batch.onebank.support;

import cn.kingnet.utp.reconciliation.exception.DownloadFileTaskValidateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * @author zhongli
 * @date 2018/9/13
 */
@Component
@Slf4j
public class DownloadFileStepExecutionListener extends StepExecutionListenerSupport {

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {

		ExecutionContext executionContext = stepExecution.getJobExecution().getExecutionContext();
		String reconcileDate = stepExecution.getJobParameters().getString("reconcileDate");
		if (null != executionContext.get("errorReconMsg" + reconcileDate)) {
			log.warn("===============================>>> " + executionContext.get("errorReconMsg" + reconcileDate).toString());
			return new ExitStatus("FINISH WITH END");
		}

		if (CollectionUtils.isEmpty(stepExecution.getFailureExceptions())) {
			return stepExecution.getExitStatus();
		}

		boolean isTrue = stepExecution.getFailureExceptions().stream()
				.filter(throwable -> throwable instanceof DownloadFileTaskValidateException && ((DownloadFileTaskValidateException) throwable).getCode() == 9564)
				.findAny().isPresent();
		if (isTrue) {
			if (isTrue) {
				log.warn("===============================>>> 华通对账文件下载失败，对账日期：{}", reconcileDate);
				return new ExitStatus("FINISH WITH END");
			}
		}

		return stepExecution.getExitStatus();
	}

}
