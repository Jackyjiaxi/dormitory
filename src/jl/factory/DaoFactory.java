package jl.factory;

import jl.bean.Admin;
import jl.bean.Dormitory;
import jl.bean.Health;
import jl.bean.Repairs;
import jl.bean.RepairsMan;
import jl.bean.Student;

public class DaoFactory {
	public static Admin getAdminInstance()
	{
		return new Admin();
	}
	public static Dormitory getDormitoryInstance()
	{
		return new Dormitory();
	}
	public static Student getStudentInstance()
	{
		return new Student();
	}
	public static Health getHealthInstance()
	{
		return new Health();
	}
	public static Repairs getRepairsInstance()
	{
		return new Repairs();
	}
	public static RepairsMan getRepairsmanInstance()
	{
		return new RepairsMan();
	}
}
