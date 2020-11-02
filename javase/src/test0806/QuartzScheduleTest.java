package test0806;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzScheduleTest {
	public static void main(String[] args) {
	 
		try {
			//类名.class得到的是一个反射技术的class对象
			//JobBuilder.newJob(PrintQuartzTask.class)通过此句话我们可以将自己写的任务与JobDetail进行关联
			JobDetail jobDetail = JobBuilder.newJob(PrintQuartzTask.class)
					.withIdentity("��ӡ����", Scheduler.DEFAULT_GROUP).build();

			//设置每5秒钟执行一次任务
			SimpleScheduleBuilder builder = SimpleScheduleBuilder.simpleSchedule()
					.withIntervalInSeconds(2)
					.repeatForever();

			//触发器
			//通常情况下在创建对象的时候使用类名.new****的时候，表示当前的类是单例模式
			Trigger trigger = TriggerBuilder.newTrigger()
					.withIdentity("simpletrigger", Scheduler.DEFAULT_GROUP)
					.startNow()
					.withSchedule(builder)
					.build();
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.scheduleJob(jobDetail, trigger);
			scheduler.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}