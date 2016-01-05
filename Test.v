
module tb_Trivium;

  wire s;
  reg [80:1] key, iv;
  reg rst, clk;
  
  integer t;

  Trivium triv(s, iv, key, rst, clk);

  initial
  begin
    key = 80'b0;
    iv = 80'b0;
    rst = 1;
    clk = 0;
    #2 rst = 0;
  end

  always
    #2 clk = ~clk;
	
  initial
    for (t = 1; t <= 2048; t = t + 1)
      #2	$display("%d:%d", t, s);

endmodule